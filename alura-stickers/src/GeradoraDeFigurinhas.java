import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;


import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    void cria(InputStream inputStream , String nomeArquivo ) throws Exception {
        String pasta = "alura-stickers/saida";

        //leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("alura-stickers/entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem em memoria com transparencia com o tamanho da imagem novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original na nova imagem com a transparencia (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        //escrever um texto na imagem
        graphics.drawString("Funcionou", 650, novaAltura - 100);

        //pasta para salvar o arquivo



        //escrever a nova imagem em arquivo
        ImageIO.write(novaImagem, "png", new File(pasta, nomeArquivo + ".png"));
    }

    
}
