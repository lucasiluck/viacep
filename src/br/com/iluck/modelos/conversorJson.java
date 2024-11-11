package br.com.iluck.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class conversorJson {

    public endereco converterJson(String json){
        Gson gson = new Gson();
        enderecoApi convertido = gson.fromJson(json, enderecoApi.class);
        endereco end = new endereco(convertido);
        return end;
    }

    public void salvarJson(endereco end) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(end.getCep()+".json");
        escrita.write(gson.toJson(end));
        escrita.close();
    }
}
