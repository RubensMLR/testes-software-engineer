package com.example.demo.utils;

import com.example.demo.models.Endereco;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class GetEnderecoByCep {

    public GetEnderecoByCep() {
    }

    public static Endereco GetDadosCep(String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        Endereco enderecoResponse = new Endereco();
        //crio o client
        ClienteHttp httpClient = new ClienteHttp();

        try {
            //abro a conecção
            HttpRequest request = httpClient.CreateHttpRequest(url);

            //envio o pacote e recupero o body do response
            String response =  httpClient.CreateCliente().send(request, HttpResponse.BodyHandlers.ofString()).body();

            JSONObject jsonBody = new JSONObject(response);
            enderecoResponse.setCep(jsonBody.getString("cep"));
            enderecoResponse.setBairro(jsonBody.getString("bairro"));
            enderecoResponse.setCidade(jsonBody.getString("localidade"));
            enderecoResponse.setComplemento(jsonBody.getString("complemento"));
            enderecoResponse.setEstado(jsonBody.getString("uf"));
            enderecoResponse.setFrete(CalcularFrete(jsonBody.getString("uf")));
            enderecoResponse.setRua(jsonBody.getString("logradouro"));

            return enderecoResponse;

        } catch ( Exception exception){
            return enderecoResponse;
        }
    }

    public static double CalcularFrete(String uf) throws Exception {
        /* Tabela com Valores fixos por região
            Sudeste (R$ 7,85), Centro-Oeste (R$ 12,50), Nordeste (R$ 15,98), Sul (R$ 17,30) e Norte (R$ 20,83)
        */
        Map<String, Double> tabelaFrete = new HashMap<>();

        tabelaFrete.put("DF",12.5);
        tabelaFrete.put("GO",12.5);
        tabelaFrete.put("MT",12.5);
        tabelaFrete.put("MS",12.5);
        tabelaFrete.put("AL",15.98);
        tabelaFrete.put("BA",15.98);
        tabelaFrete.put("CE",15.98);
        tabelaFrete.put("MA",15.98);
        tabelaFrete.put("PB",15.98);
        tabelaFrete.put("PE",15.98);
        tabelaFrete.put("PI",15.98);
        tabelaFrete.put("RN",15.98);
        tabelaFrete.put("SE",15.98);
        tabelaFrete.put("AC",20.83);
        tabelaFrete.put("AP",20.83);
        tabelaFrete.put("AM",20.83);
        tabelaFrete.put("PA",20.83);
        tabelaFrete.put("RO",20.83);
        tabelaFrete.put("RR",20.83);
        tabelaFrete.put("TO",20.83);
        tabelaFrete.put("ES",7.85);
        tabelaFrete.put("MG",7.85);
        tabelaFrete.put("RJ",7.85);
        tabelaFrete.put("SP",7.85);
        tabelaFrete.put("PR",17.3);
        tabelaFrete.put("RS",17.3);
        tabelaFrete.put("SC",17.3);

        if(tabelaFrete.containsKey(uf)){
            return tabelaFrete.get(uf);
        } else {
            throw new Exception(); //todas as UF's devem estar mapeadas no MAP;
        }
    }
}
