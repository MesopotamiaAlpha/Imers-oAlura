import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // acessar a URL
        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        for (int i = 0; i < 3; i++) {

            // exbir e manipular os dados (JSON)
            ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
            List<Conteudo> conteudos = extrator.extraiConteudos(json);
            Conteudo conteudo = conteudos.get(i); 

                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

                // tentando arrumar a string para pegar a imagem correta
                // urlImagem = urlImagem.replace("_V1_UX128_CR0,1,128,176_AL_", ".png");

                String nomeArquivo = conteudo.getTitulo();

                var geradora = new GeradoraDeFigurinhas();
                geradora.cria(inputStream, nomeArquivo);

                System.out.println("\u001b[1m");
                System.out.println(conteudo.getTitulo());
                System.out.println();
            
        }
    }
}
