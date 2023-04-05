package ImbdAPi;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * passos:
 * 1-ler uma imagem
 * 2-criar nova imagem em momemoria com transparencia e tamanho novo
 * 3-copiar a img original para nova img na memoria
 * 4-escrever uma frase na img
 * 5-escrever a nova img em um arquivo
 */
public class StickerGen {
    
    //1
    public void gerar(InputStream inputStream, String nomeArquivo, String texto, InputStream imgSobrepor) throws Exception{ //dentro do metodo void pode usar o inputstream chamando em outra classe

        // BufferedImage imgOriginal = ImageIO.read(new File("D:/JAVAPROJECTS/Imersao
        // Java/ImbdAPi/input/filme.jpg")); 
        //acesso direto de um diretorio/arquivo >> o tamanho salvo da foto muda, diferente da url
        
        // InputStream inputStream = new FileInputStream(new
        // File("D:/JAVAPROJECTS/Imersao Java/ImbdAPi/input/filme.jpg"));         
        //abstrai a forma de acesso podendo ser de qualquer fonte de dados
        
        // InputStream inputStream = new
        // URL("https://m.media-amazon.com/images/M/MV5BMWE3MGYzZjktY2Q5Mi00Y2NiLWIyYWUtMmIyNzA3YmZlMGFhXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream(); 
        // se inserido manualmente uma URL
    
    BufferedImage imgOriginal =  ImageIO.read(inputStream); //entrada fig
    
    //2
    int largura = imgOriginal.getWidth();
    int altura = imgOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    //3
    Graphics2D graphics = (Graphics2D) novaImg.getGraphics();
    graphics.drawImage(imgOriginal, 0, 0, null);
    

    // BufferedImage imagemsobrepocisao = ImageIO.read(imgSobrepor);
    // int posImagemSobreporY = novaAltura - imagemsobrepocisao.getHeight();
    // graphics.drawImage(imagemsobrepocisao, 0, posImagemSobreporY, null);

    //setar a fonte
    var fonte = new Font(("Impact Regular"), Font.BOLD,64); //configurando a fonte
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);
    

    //4
    
    //calculos p/ descobrir o meio da imagem
    FontMetrics fontMetrics = graphics.getFontMetrics(); // pegar o tamanho do texto px/px
    Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
    int larguraTexto = (int) retangulo.getWidth();
    int posicaoTextoX = (largura - larguraTexto) / 2; 
    int posicaoTextoY = novaAltura - 70;
    
    graphics.drawString(texto, posicaoTextoX, posicaoTextoY);
    
    //outline do texto
    FontRenderContext fontRender = graphics.getFontRenderContext();
    var textLayout = new TextLayout(texto, fonte, fontRender);
    Shape outline = textLayout.getOutline(null);
    AffineTransform transform = graphics.getTransform();
    transform.translate(posicaoTextoX, posicaoTextoY);
    graphics.setTransform(transform);
    
    var outlineStroke = new BasicStroke(largura * 0.002f);
    graphics.setStroke(outlineStroke);
    graphics.setColor(Color.BLACK);
    graphics.draw(outline);
    graphics.setClip(outline);
    
    graphics.drawString("MASSA", 100, novaAltura - 100);
    
    //5
    ImageIO.write(novaImg, "png", new File(nomeArquivo)); //saida fig
}

    public void gerar(InputStream inputStream, String nomeArquivo) {
    }

    // public static void main(String[] args) throws Exception {
    //     var gerador = new StickerGen();
    //     gerador.gerar();
    // } se utilizado o construtor gerador.gerar()
    
}
