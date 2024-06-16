package assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButton extends JButton {

    public MenuButton(){
        this.setFont(Fonts.SATOSHI_15.getFont());
        this.setForeground(new Color(0x222222));
        this.setBackground(null);
        this.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setForeground(new Color(102, 102, 102));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setForeground(new Color(0x222222));
            }
        });

    }

}
