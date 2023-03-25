package com.example.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HelloWorldClient {
    public static void main(String[] args) throws IOException {
        String baseUri = "http://localhost:8080/api"; // base URI
        String username = "user";
        String password = "password";
        String name = "akshata";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("hello").queryParam("name", name);

        String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
        Response response = target.request(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.AUTHORIZATION, authHeaderValue)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("Response: " + response.readEntity(String.class));
        } else {
            System.out.println("Failed with status: " + response.getStatus());
        }

        response.close();
        client.close();
    }
}
