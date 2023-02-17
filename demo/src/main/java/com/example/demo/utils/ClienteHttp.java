package com.example.demo.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ClienteHttp {
    public ClienteHttp() {
    }
    public static HttpClient CreateCliente() {
        return HttpClient.newHttpClient();
    }
    public static HttpRequest CreateHttpRequest(String url) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                //.header("Content-Type", "application/json")
                .build();
    }

}
