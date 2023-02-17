package com.example.demo.controllers;

import com.example.demo.models.Endereco;
import com.example.demo.utils.GetEnderecoByCep;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EnderecoController {
    /*  Contrato:
        POST v1/consulta-endereco
        REQUEST
        {
        "cep": "01001000"
        }
        RESPONSE HTTP 200
        {
        "cep": "01001-000",
        "rua": "Praça da Sé",
        "complemento": "lado ímpar",
        "bairro": "Sé",
        "cidade": "São Paulo",
        "estado": "SP",
        "frete": 7.85
        }
     */
    @PostMapping(path = "/v1/consulta-endereco", produces = "application/json")
    public static String ConsultaEndereco_v1(@RequestBody String body) throws JSONException {
        String cepInvalido = "{\"message\": \"O cep informado não está no formato correto {0-9}{8}. EX: 29165827\"}";
        String cepInexistente = "{\"message\": \"O cep informado não existe na base de dados do IBGE.\"}";
        String reqCep = "";
        Endereco response = new Endereco();
        Gson gson = new Gson();
        GetEnderecoByCep getEnderecoByCep = new GetEnderecoByCep();

        try{
            JSONObject jsonBody = new JSONObject(body);
            reqCep = jsonBody.getString("cep");
            if(ValidaCep(reqCep)){
                response = GetEnderecoByCep.GetDadosCep(reqCep);
                return response.getCep().isBlank() || response.getCep().isEmpty() ? cepInexistente : gson.toJson(response);
            } else{
                return cepInvalido;
            }

        } catch (JSONException ex){
            return String.format("{ \"error\": \" %s \"", ex.getMessage());
        }
    }

    public static boolean ValidaCep(String cep){
        return cep.length() == 8 && !cep.isBlank() && cep.matches("[0-9]+");
    }
}
