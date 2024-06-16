package appElements;

import assets.ColorPool;
import assets.Fonts;

import javax.swing.*;
import java.awt.*;

public class SearchBarPanel extends JPanel {

    JTextField searchBar;

    SearchBarPanel() {

        setBackground(ColorPool.BACKGROUND_GREY.getColor());

        JLabel text = new JLabel("Głosuj z nami i zmieniaj Warszawę!");
        text.setFont(Fonts.SATOSHI_20.getFont());

        searchBar = new JTextField();
        searchBar.setToolTipText("Search...");
        searchBar.setPreferredSize(new Dimension(300, 30));
        searchBar.setMinimumSize(new Dimension(100, 30));
        searchBar.setMaximumSize(new Dimension(300, 30));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(text, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(searchBar, gbc);
    }

}
