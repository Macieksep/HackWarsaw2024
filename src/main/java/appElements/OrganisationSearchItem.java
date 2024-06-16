package appElements;

import assets.Fonts;

import javax.swing.*;
import java.awt.*;

public class OrganisationSearchItem extends JPanel {

    public JLabel nameLabel;
    private JLabel imageLabel;
    private JPanel centerContainer;
    public JButton organisationButton;


    public OrganisationSearchItem(ImageIcon imageIcon, String name){
        centerContainer = new JPanel();
        centerContainer.setLayout(new BorderLayout());
        centerContainer.setPreferredSize(new Dimension(400, 50));
        centerContainer.setBackground(null);
        GridBagConstraints gbc = new GridBagConstraints();
        organisationButton = new JButton(name);
        organisationButton.setIcon(imageIcon);
        organisationButton.setBackground(new Color(0xf8f8f8));
        organisationButton.setFocusable(false);
        organisationButton.setFont(Fonts.SATOSHI_10.getFont());
        organisationButton.setBorder(null);
        organisationButton.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        centerContainer.add(organisationButton, BorderLayout.CENTER);

        this.setBackground(null);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(300, 50));
        this.setLayout(new BorderLayout());

        this.add(centerContainer, BorderLayout.CENTER);
    }

}