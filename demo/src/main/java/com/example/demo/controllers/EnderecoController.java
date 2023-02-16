package com.example.demo.controllers;

import com.example.demo.GetEnderecoByCep;
import com.example.demo.models.Endereco;
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
    @PostMapping(path = "/v1/consulta-endereco")
    public static String ConsultaEndereco_v1(@RequestBody String body){
        String error = "{\"message\": \"O cep informado não está no formato correto {0-9}{8}. EX: 29165827\"}";
        String reqCep = "";
        Endereco response = new Endereco();
        GetEnderecoByCep getEnderecoByCep = new GetEnderecoByCep();

        try{
            JSONObject jsonBody = new JSONObject(body);
            reqCep = jsonBody.getString("cep");
            if(ValidaCep(reqCep)){
                response = getEnderecoByCep.GetDadosCep(reqCep);
                return response.toString();
            } else{
                return error;
            }

        } catch (JSONException ex){
            return "error: " + ex.getMessage();
        }
    }

    public static boolean ValidaCep(String cep){
        return cep.length() == 8 && !cep.isEmpty() && !cep.isBlank() && cep.matches("[0-9]+");
    }
}
