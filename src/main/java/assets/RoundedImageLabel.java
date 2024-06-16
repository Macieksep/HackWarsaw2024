package assets;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedImageLabel extends JLabel {
    private ImageIcon imageIcon;
    private int cornerRadius;

    public RoundedImageLabel(ImageIcon imageIcon, int cornerRadius) {
        this.imageIcon = imageIcon;
        this.cornerRadius = cornerRadius;
        setOpaque(false);
        setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = imageIcon.getImage();

        RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setClip(roundRect);

        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());
    }
}