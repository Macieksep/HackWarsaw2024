package appElements;

import assets.ColorPool;
import assets.MenuButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class OptionPanel extends JPanel  {

    public JPanel buttonsPanel = new JPanel();
    public MenuButton projects = new MenuButton();
    public MenuButton donateOrganisation = new MenuButton();
    public JButton homeButton = new JButton(scaleImage(20,20, new File("src/main/java/assets/gfx/houseIcon.png")));
    public JLabel logoLabel = new JLabel();


    OptionPanel(CardLayout cardLayout, JPanel sceneChanger){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        setBackground(ColorPool.BACKGROUND_GREY.getColor());
        buttonsPanel.setBackground(ColorPool.BACKGROUND_GREY.getColor());

        logoLabel.setIcon(scaleImage(100, 50, new File("src/main/java/assets/gfx/logo.jpg")));

        buttonsPanel.add(projects);
        buttonsPanel.add(donateOrganisation);
        buttonsPanel.add(homeButton);
        updateHomeButton();

        projects.setText("Add project");
        donateOrganisation.setText("Donate  Organisations");

        projects.addActionListener(e -> {

            System.out.println("Poll");
            cardLayout.show(sceneChanger, "PollCreator");

        });

        donateOrganisation.addActionListener(e -> {

            System.out.println("Donation");
            cardLayout.show(sceneChanger, "Donation");

        });



        homeButton.addActionListener(e -> {

            System.out.println("mainmen");
            cardLayout.show(sceneChanger, "MainMenu");

        });

        setLayout(new BorderLayout());

        add(logoLabel, BorderLayout.WEST);
        add(buttonsPanel, BorderLayout.EAST);

    }

    ImageIcon scaleImage(int width, int height, File file) {

        Image scaledImage = new ImageIcon(file.getPath())
                .getImage()
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);

    }

    void updateHomeButton(){
        homeButton.setBackground(null);
        homeButton.setFocusable(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setBorderPainted(false);
        homeButton.setOpaque(true);
    }

}
