package appElements;

import assets.ColorPool;

import javax.swing.*;
import java.awt.*;

public class AppWin extends JFrame {

    public AppWin(String title){

        setTitle(title);
        setIconImage(new ImageIcon("src/main/java/assets/gfx/logoIcon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setBackground(ColorPool.BACKGROUND_GREY.getColor());
        setExtendedState(MAXIMIZED_BOTH);

    }

}
