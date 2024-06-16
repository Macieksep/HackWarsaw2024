package appElements;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Project extends JPanel {
    PollCreator pollCreator;
    String locationAsString = "";
    String projectDescriptionAsString = "";
    String dateAsString = "";
    JLabel image = new JLabel();
    JTextField location = new JTextField(20);
    JButton chooseImage = new JButton("Choose Image");
    JButton submit = new JButton("Submit");
    JLabel date = new JLabel("Release Date:");
    JTextField releaseDate = new JTextField(20);
    JButton saveLocationButton = new JButton("Save");
    JButton saveDateButton = new JButton("Save");
    JButton saveDescriptionButton = new JButton("Save");
    JLabel descriptionLabel = new JLabel("Project Description:");
    JTextArea projectDescription = new JTextArea(5, 20);
    JScrollPane descriptionScrollPane = new JScrollPane(projectDescription);
    JButton exit = new JButton("Submit");

    public Project(PollCreator pollCreator) {
        this.pollCreator = pollCreator;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(date, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(releaseDate, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(saveDateButton, gbc);
        saveDateButton.addActionListener(e -> {
            dateAsString = releaseDate.getText();
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Project name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(location, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(saveLocationButton, gbc);
        saveLocationButton.addActionListener(e -> {
            locationAsString = location.getText();
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(descriptionScrollPane, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(saveDescriptionButton, gbc);
        saveDescriptionButton.addActionListener(e -> {
            projectDescriptionAsString = projectDescription.getText();
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(chooseImage, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(submit, gbc);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project2 project2 = new Project2(locationAsString, dateAsString, projectDescriptionAsString, image);
                pollCreator.getProjectList().add(project2);
                CardLayout cardLayout = (CardLayout) pollCreator.getParent().getLayout();
                cardLayout.show(pollCreator.getParent(), "PollCreator");
            }
        });



        chooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
                int returnValue = fileChooser.showOpenDialog(Project.this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                    image.setIcon(imageIcon);
                }
            }
        });
    }
}