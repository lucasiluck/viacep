package br.com.iluck.modelos;

import br.com.iluck.exceptions.numberQntException;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class geradorJson {

    public String gerarJson(String cep) throws IOException, InterruptedException {

        String url = "https://viacep.com.br/ws/"+URLEncoder.encode(cep,StandardCharsets.UTF_8)+"/json/";
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 400) {
            throw new numberQntException("CEP não encontrado tente novamente");
        } else {
            return response.body();
        }
    }
}
