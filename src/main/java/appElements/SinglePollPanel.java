package appElements;

import assets.ColorPool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SinglePollPanel extends JPanel {

    BufferedImage pollImage;

    public SinglePollPanel(){
        this.setBackground(ColorPool.BACKGROUND_GREY.getColor());
        this.setOpaque(true);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        try {
            BufferedImage pollImage = ImageIO.read(new File("src/main/java/assets/logo.jpg"));
        } catch (IOException e ){
            e.printStackTrace();
        }



    }

}
