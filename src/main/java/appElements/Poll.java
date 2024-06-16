package appElements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Poll extends JPanel {
    ArrayList<Project2> projectList;

    public Poll(ArrayList<Project2> projectList, CardLayout cardLayout, JPanel sceneChanger) {
        this.projectList = projectList;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        OptionPanel optionPanel = new OptionPanel(cardLayout, sceneChanger);
        topPanel.add(optionPanel, BorderLayout.WEST);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(topPanel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        for (int i = 0; i < projectList.size(); i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;
            add(projectList.get(i), gbc);
        }
    }

    public void setProjectList(ArrayList<Project2> projectList) {
        this.projectList = projectList;
        removeAll();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < projectList.size(); i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;
            add(projectList.get(i), gbc);
        }

        revalidate();
        repaint();
    }
}