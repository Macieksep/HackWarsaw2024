package appElements;

import assets.ColorPool;
import assets.Fonts;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProjectSearchItem extends JPanel {

    static ArrayList<ProjectSearchItem> searchItems = new ArrayList<>();

    JLabel imageLabel = new JLabel();
    JLabel titleLabel = new JLabel();
    JLabel dateLabel = new JLabel();
    JLabel subTitleLabel = new JLabel();
    JButton readButton = new JButton();

    ProjectSearchItem(String title, String subtitle, Date date, File image){

        readButton.setText("Continue");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(ColorPool.BACKGROUND_GREY.getColor());

        imageLabel.setIcon(scaleAndRoundImage(200, 140, 15, image));
        titleLabel.setText(title);
        titleLabel.setFont(Fonts.SATOSHI_15.getFont());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateLabel.setText(simpleDateFormat.format(date));

        dateLabel.setForeground(new Color(102,102,102));
        dateLabel.setFont(Fonts.SATOSHI_10.getFont());

        subTitleLabel.setText(subtitle);
        subTitleLabel.setForeground(new Color(102,102,102));
        subTitleLabel.setFont(Fonts.SATOSHI_10.getFont());

        readButton.setFont(Fonts.SATOSHI_15.getFont());
        readButton.setBackground(Color.gray);
        readButton.setForeground(new Color(0x222222));
        readButton.setFocusable(false);
        readButton.setBorderPainted(false);

        readButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                readButton.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                readButton.setBackground(Color.GRAY);
            }
        });

        add(imageLabel);
        add(titleLabel);
        add(dateLabel);
        add(subTitleLabel);
        add(readButton);

        add(Box.createVerticalStrut(10));
    }

    public static ImageIcon scaleAndRoundImage(int width, int height, int cornerRadius, File file) {
        try {
            BufferedImage originalImage = ImageIO.read(file);

            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius);

            g2d.clip(roundRect);

            g2d.drawImage(scaledImage, 0, 0, null);

            g2d.dispose();

            return new ImageIcon(bufferedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void loadData(){

        searchItems.add(new ProjectSearchItem("Project 1", "Description 1", new Date(new Date().getTime()), new File("src/main/java/assets/exampleData/bathrooms.jpg")));
        searchItems.add(new ProjectSearchItem("Project 2", "Description 2", new Date(new Date().getTime()), new File("src/main/java/assets/exampleData/city.jpg")));
        searchItems.add(new ProjectSearchItem("Project 3", "Description 3", new Date(new Date().getTime()), new File("src/main/java/assets/exampleData/poland1.jpg")));
        searchItems.add(new ProjectSearchItem("Project 4", "Description 4", new Date(new Date().getTime()), new File("src/main/java/assets/exampleData/poland2.jpg")));
        searchItems.add(new ProjectSearchItem("Project 5", "Description 5", new Date(new Date().getTime()), new File("src/main/java/assets/exampleData/warsaw1.jpg")));
        searchItems.add(new ProjectSearchItem("Project 6", "Description 6", new Date(new Date().getTime()), new File("src/main/java/assets/exampleData/warsaw2.jpg")));
        searchItems.add(new ProjectSearchItem("Project 7", "Description 7", new Date(new Date().getTime()), new File("src/main/java/assets/exampleData/warsaw3.jpg")));

    }

}
