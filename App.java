import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os tops 250 TV Shows
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send (request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)+
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeProgamasDeTV = parser.parse(body);
        System.out.println(ListaDeProgamasDeTV.size());
        System.out.println(ListaDeProgamasDeTV.get(0));
        
        // exibir e manipular os dados
        for (Map<String,String> programa : ListaDeProgamasDeTV) {
            System.out.println(programa.get("title"));
            System.out.println(programa.get("image"));
            System.out.println(programa.get("imDbRating"));
        }
            
            
            
        }

    }   



