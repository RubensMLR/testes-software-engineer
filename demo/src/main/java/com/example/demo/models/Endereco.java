package com.example.demo.models;

public class Endereco {
    private String cep = "";
    private String rua = "";
    private String complemento = "";
    private String bairro = "";
    private String cidade = "";
    private String estado = "";
    private double frete = 0;

    public Endereco() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    /*
    @Override
    public String toString() {
        String jsonString = String.format("{\"cep\":\"%s\", " +
                                           "\"rua\":\"%s\", " +
                                           "\"complemento\":\"%s\", " +
                                           "\"bairro\":\"%s\", " +
                                           "\"cidade\":\"%s\", " +
                                           "\"estado\":\"%s\", " +
                                           "\"frete\":%.2f}", cep, rua, complemento, bairro, cidade, estado, frete);
        return  jsonString;
    }

     */
}
