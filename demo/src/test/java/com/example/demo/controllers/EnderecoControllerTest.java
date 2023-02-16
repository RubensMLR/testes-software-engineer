package com.example.demo.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoControllerTest {

    @Test
    @DisplayName("Validando response de body Válido, Alfanumérico, Mais de 8 dígitos, Com espaço")
    void consultaEndereco_v1() {
        String bodyValido = "{ \"cep\": \"29165827\"}";
        String bodyAlfanumerico = "{ \"cep\": \"29165827a\"}";
        String bodyMaior = "{ \"cep\": \"291658276\"}";
        String bodyComEspaco = "{ \"cep\": \"29165827 \"}";

        String responseValido = "{ \"cep\":\"29165-827\", \"rua\":\"Rua Marataízes\", \"complemento\":\"\", \"bairro\":\"Valparaíso\", \"cidade\":\"Serra\", \"estado\":\"ES\", \"frete\":7.85}";
        String responseInvalido = "{\"message\": \"O cep informado não está no formato correto {0-9}{8}. EX: 29165827\"}";

        assertAll(
                ()-> assertEquals(responseValido, EnderecoController.ConsultaEndereco_v1(bodyValido)),
                ()-> assertEquals(responseInvalido, EnderecoController.ConsultaEndereco_v1(bodyAlfanumerico)),
                ()-> assertEquals(responseInvalido, EnderecoController.ConsultaEndereco_v1(bodyMaior)),
                ()-> assertEquals(responseInvalido, EnderecoController.ConsultaEndereco_v1(bodyComEspaco))
        );
    }

    @Test
    @DisplayName("Validando Cep Válido, Alfanumérico, Mais de 8 dígitos, Com espaço")
    void validaCep() {
        String cepValido = "29165827";
        String cepAlfanumerico = "29165827a";
        String cepMaior = "291658276";
        String cepComEspaco = "29165827 ";

        assertAll(
                ()-> assertEquals(true, EnderecoController.ValidaCep(cepValido)),
                ()-> assertEquals(false, EnderecoController.ValidaCep(cepAlfanumerico)),
                ()-> assertEquals(false, EnderecoController.ValidaCep(cepMaior)),
                ()-> assertEquals(false, EnderecoController.ValidaCep(cepComEspaco))
        );
    }
}