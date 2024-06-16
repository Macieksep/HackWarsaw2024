package appElements;

import javax.swing.*;
import java.awt.*;

public class Project2 extends JPanel {
    JLabel projectNameLabel = new JLabel();
    JLabel releaseDateLabel = new JLabel();
    JLabel projectDescriptionLabel = new JLabel();
    JLabel imageLabel = new JLabel();

    public Project2(String projectName, String releaseDate, String projectDescription, JLabel image) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        projectNameLabel.setText("Project Name: " + projectName);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(projectNameLabel, gbc);

        releaseDateLabel.setText("Release Date: " + releaseDate);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(releaseDateLabel, gbc);

        projectDescriptionLabel.setText("Project Description: " + projectDescription);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(projectDescriptionLabel, gbc);

        imageLabel.setIcon(image.getIcon());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(imageLabel, gbc);
    }
}