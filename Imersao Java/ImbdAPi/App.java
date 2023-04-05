package ImbdAPi;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * 1-fazer uma conexao http e buscar top 250 filmes do imdb
 * 2-extrair dados que interessam (titulo, poster, rating)
 * 3-exibir e manipular os dados
 * 
 * guias json:
 * Top Filmes Populares: https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbmostpopularmovies.json
 * Top 250 Filmes Imdb: https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json
 * Top 250 Series Imdb: https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbTop250TVs.json
 */
public class App {
    public static void main(String[] args) throws Exception {
       
        //API api = API.IMBD_TOP250_SERIES;

    // 1
    // String url = api.getUrl();
    // ExtratorDeConteudo extrator = api.getExtrator(); 

    String url = "http://localhost:8080/linguagens";
    ExtratorConteudoImbd extrator = new ExtratorConteudoImbd();
    
    
       
        var http = new ClientHttp();
        String json = http.buscarDados(url);    
        
        var path = new File("figurinhas/");
        path.mkdir(); // cria nova pasta pra gerar os arquivos
               
        List<Conteudo> conteudos = extrator.extraiConteudo(json);
       
        var gerador = new StickerGen();
        
        //for (Map<String,String> conteudo : listaDeConteudo) { //no foreach map = TODOS os filmes separados
            for (int i = 0; i < 7; i++) { //listar n conteudos
                
                Conteudo conteudo = conteudos.get(i);
                
                InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
                String nomeArquivo = "figurinhas/" + conteudo.titulo() + ".png";          
                
                System.out.println();            
                
                gerador.gerar(inputStream, nomeArquivo, "MASSA", null);
                
                System.out.println("\u001b[1m\u001b[3m\u001b[7mTitulo:\u001b[m " + conteudo.titulo());
                System.out.println("\u001b[4mURL Cover:\u001b[m "+ conteudo.urlImagem());
            
        }
    
    }
}
