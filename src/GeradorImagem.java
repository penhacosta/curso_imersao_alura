import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradorImagem {


    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
    // leitura da im agem
    //BufferedImage imageOriginal = ImageIO.read(new File("entrada/filmes.jpg"));
    // url = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg";
    // inputStream = 
     // new URL(url).openStream();
    
    BufferedImage imageOriginal = ImageIO.read(inputStream);

    // criar nova imagem em memória com transparencia e com tamanho novo
    int largura = imageOriginal.getWidth();
    int altura  = imageOriginal.getHeight();
    int novaAltrua =  altura + 200;
    BufferedImage novaImage = new BufferedImage(largura, novaAltrua,BufferedImage.TRANSLUCENT);

    // copiar a imagem original para novo imagem (em memória)
      Graphics2D graphics = (Graphics2D) novaImage.getGraphics();
      graphics.drawImage(imageOriginal, 0, 0, null); 


      //configurar a fonte
      graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
    
      // escrever um frase
      graphics.drawString("WALL",0, novaAltrua - 100);
    
      // escrever uma frase na nova imagem
    ImageIO.write(novaImage, "png", new File(nomeArquivo));
    }
    
}
