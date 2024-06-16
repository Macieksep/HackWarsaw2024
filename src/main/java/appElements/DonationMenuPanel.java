package appElements;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class DonationMenuPanel extends JPanel {

    private JPanel searchArea;
    private SearchBarPanel searchBarPanel;
    private ArrayList<OrganisationSearchItem> allItems;

    public DonationMenuPanel(CardLayout cardLayout, JPanel sceneChanger) {
        searchBarPanel = new SearchBarPanel();
        searchBarPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        searchArea = new JPanel(new GridLayout(0, 1));
        searchArea.setBackground(new Color(0xf8f8f8));
        allItems = new ArrayList<>();

        OrganisationSearchItem item2 = new OrganisationSearchItem(ProjectSearchItem.scaleAndRoundImage(35, 35, 30, new File("src/main/java/assets/gfx/free-images.jpg")), "ASCI Organisation");
        allItems.add(item2);
        searchArea.add(item2);

        for (int i = 0; i < 20; i++) {
            OrganisationSearchItem item = new OrganisationSearchItem(ProjectSearchItem.scaleAndRoundImage(35, 35, 30, new File("src/main/java/assets/gfx/free-images.jpg")), "ASCI Organisation");
            allItems.add(item);
            searchArea.add(item);
        }

        JScrollPane scrollPane = new JScrollPane(searchArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        OptionPanel optionPanel = new OptionPanel(cardLayout, sceneChanger);
        optionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        bottomPanel.add(searchBarPanel);
        bottomPanel.add(scrollPane);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        searchBarPanel.searchBar.addActionListener(e -> {
            String searchText = searchBarPanel.searchBar.getText().trim();
            updateSearchResults(searchText);
        });

        add(optionPanel);
        add(bottomPanel);
    }

    private void clearSearchResults() {
        searchArea.removeAll();
        revalidate();
        repaint();
    }

    private void updateSearchResults(String searchText) {
        for (OrganisationSearchItem item : allItems) {
            boolean match = item.organisationButton.getText().toLowerCase().contains(searchText.toLowerCase());
            item.setVisible(match);
            if (match) {
                searchArea.add(item);
            }
        }

        revalidate();
        repaint();
    }
}