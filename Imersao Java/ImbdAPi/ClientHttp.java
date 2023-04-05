package ImbdAPi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class ClientHttp {
    
    public String buscarDados(String url){
       
        try{
            URI endereco = URI.create(url); // identificacao da url
            HttpClient client = HttpClient.newHttpClient(); //cria um client para fazer e receber requisicoes
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); // construtor request
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;

        } catch(IOException | InterruptedException ex){ // caso de uma excessao aplica este metodo
            throw new ClientHttpException("Erro de consulta URL");

        }
    }

}
