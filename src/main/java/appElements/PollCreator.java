package appElements;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class PollCreator extends JPanel {
    ArrayList<Project2> projectList = new ArrayList<>();
    String pollDescriptionAsString = "";
    JButton createProject = new JButton("Create Project");
    JButton chooseImage = new JButton("Choose Image");
    JLabel image = new JLabel();
    JLabel descriptionLabel = new JLabel("Project Description:");
    JTextArea pollDescription = new JTextArea(5, 20);
    JScrollPane descriptionScrollPane = new JScrollPane(pollDescription);
    JButton saveDescriptionButton = new JButton("Save");
    JButton submitButton = new JButton("Submit");
    Poll poll;

    CardLayout cardLayout;
    JPanel mainPanel;

    public PollCreator(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        add(chooseImage, gbc);

        chooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
                int returnValue = fileChooser.showOpenDialog(PollCreator.this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                    image.setIcon(imageIcon);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        image.setHorizontalAlignment(JLabel.CENTER);
        add(image, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(descriptionScrollPane, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(saveDescriptionButton, gbc);
        saveDescriptionButton.addActionListener(e -> {
            pollDescriptionAsString = pollDescription.getText();
        });

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(createProject, gbc);
        createProject.addActionListener(e -> {
            Project project = new Project(this);
            mainPanel.add(project, "project");
            cardLayout.show(mainPanel, "project");
        });

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        add(submitButton, gbc);
        submitButton.addActionListener(e -> {
            poll = new Poll(projectList, cardLayout, mainPanel);
            mainPanel.add(poll, "poll");
            cardLayout.show(mainPanel, "poll");
        });
    }

    public ArrayList<Project2> getProjectList() {
        return projectList;
    }


}