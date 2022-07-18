import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        // acessar a URL
        String url = "https://imdb-api.com/en/API/Top250Movies/k_4npyfvog";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        //ref https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html
        var request = HttpRequest.newBuilder(endereco).GET().build();

        //extrair somente os dados que interessam (titulo,poster,classificação)
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //exbir e manipular os dados (JSON)
        
    }
}
