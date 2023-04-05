package ImbdAPi;

import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorDeConteudo {
   
    public List<Conteudo> extraiConteudo (String json){
        
        //extrair dados que interessam (titulo, poster, rating)
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json); //funciona como um mapa, dicionario (key/value)
        
        return listaDeAtributos.stream()
            .map((Map<String, String> atributos) -> { //stream & lambda ->
        return new Conteudo(atributos.get("title"), 
            atributos.get("url"));
        
        }).toList();

        
    }
    
}
