import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");

       // fazer uma conexao Http e buscar os top 250 filmes

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient .newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);
     
       
        // extrair só os dads que interessam (titulo, poster, classificação)
        var parse = new JsonParser(); // instancia a classe JsonParser
        List<Map<String, String>> listaDeFilmes =  parse.parse(body);

        // exibir e manipular os dados
       System.out.println(listaDeFilmes.size());

       for (Map<String,String> filme : listaDeFilmes) {
          
         String urlImagem = filme.get("image");
         String titulo = filme.get("title");
         
         InputStream inputStream = new URL(urlImagem).openStream();
         String nomeArquivo = titulo + ".png";
          
         var geradora = new GeradorImagem();
         geradora.cria(inputStream, nomeArquivo);

         System.out.println(titulo);
         System.out.println();
          
       }
    }
}
