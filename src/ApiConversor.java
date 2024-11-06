import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ApiConversor {

    String urlBase = "https://v6.exchangerate-api.com/v6/";
    String apiKey = "a84670658dbe35921ef7d985/";
    String par = "pair/";


    public ApiConversor() throws IOException, InterruptedException {
        while (true){
            try {
                System.out.println("Escolha uma das opções para identificar qual moeda você quer converter ou aperte 7 para sair");
                Scanner leitura = new Scanner(System.in);
                int escolha1 = leitura.nextInt();

                Map<Integer, String> opcao = new HashMap<>();
                opcao.put(1, "BRL");
                opcao.put(2, "ARS");
                opcao.put(3, "USD");
                opcao.put(4, "JMD");
                opcao.put(5, "CAD");
                opcao.put(6, "RUB");
                if (escolha1 > 7) {
                    throw new OpcaoException("A opção não existe");
                }
                if (escolha1 == 7) {
                    System.out.println("Você apertou 7. Obrigado por usar o nosso sistema");
                    break;
                } else {
                    System.out.println("Agora escolha para qual moeda que vc quer converter");
                    int escolha2 = leitura.nextInt();

                    if (escolha2 > 6){
                        throw new OpcaoException("A opção não existe");
                    }

                    System.out.println("Agora coloque o valor a ser convertido");
                    double montante = leitura.nextDouble();

                    HttpClient cliente = HttpClient.newHttpClient();

                    HttpRequest requisicao = HttpRequest.newBuilder()
                            .GET()
                            .uri(URI.create(STR."\{urlBase}\{apiKey}\{par}\{opcao.get(escolha1)}/\{opcao.get(escolha2)}/\{montante}"))
                            .build();
                    HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

                    String json = resposta.body();
                    Gson gson = new Gson();
                    Conversor resultado = gson.fromJson(json, Conversor.class);
                    String moedaDestino = opcao.get(escolha2);
                    System.out.println(resultado.toString(moedaDestino));

                }

            } catch (OpcaoException | InputMismatchException a) {
            System.out.println("A opção não existe. Você digitou um número que não está na lista");
        }
            }
    }
}