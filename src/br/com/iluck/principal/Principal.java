package br.com.iluck.principal;

import br.com.iluck.exceptions.numberQntException;
import br.com.iluck.modelos.conversorJson;
import br.com.iluck.modelos.endereco;
import br.com.iluck.modelos.geradorJson;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        geradorJson api = new geradorJson();
        String busca = "";

        System.out.println("Digite o CEP que deseja pesquisar");
        busca = scan.nextLine();
        while (!busca.equalsIgnoreCase("sair")) {
            try {
                String json = api.gerarJson(busca);
                System.out.println(busca);
                conversorJson conversor = new conversorJson();
                endereco convertido = conversor.converterJson(json);
                System.out.println(convertido.toString());
                conversor.salvarJson(convertido);

            } catch (numberQntException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Digite outro CEP ou 'sair' para encerar aplicação");
            busca = scan.nextLine();
        }
        System.out.println("Aplicação encerrada");
    }
}
