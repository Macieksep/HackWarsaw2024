package appElements;

import assets.ColorPool;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainMenuPanel extends JPanel {

    private JPanel searchArea;
    private SearchBarPanel searchBarPanel;
    private ArrayList<ProjectSearchItem> allItems;

    public MainMenuPanel(CardLayout cardLayout, JPanel sceneChanger) {
        searchBarPanel = new SearchBarPanel();
            searchBarPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        searchArea = new JPanel(new GridLayout(0, 3));
        searchArea.setBackground(ColorPool.BACKGROUND_GREY.getColor());

        int padding = 10;
        searchArea.setBorder(BorderFactory.createLineBorder(ColorPool.BACKGROUND_GREY.getColor(), padding));

        allItems = new ArrayList<>();

        ProjectSearchItem.loadData();

        allItems.addAll(ProjectSearchItem.searchItems);
        for (ProjectSearchItem i : allItems)
            searchArea.add(i);

        JScrollPane scrollPane = new JScrollPane(searchArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        OptionPanel optionPanel = new OptionPanel(cardLayout, sceneChanger);
            optionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        bottomPanel.add(searchBarPanel);
        bottomPanel.add(scrollPane);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(ColorPool.BACKGROUND_GREY.getColor());

        searchBarPanel.searchBar.addActionListener(e -> {

            String searchText = searchBarPanel.searchBar.getText().trim();
            clearSearchResults();
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
        searchArea.removeAll();

        for (ProjectSearchItem item : allItems) {
            boolean match = item.titleLabel.getText().toLowerCase().contains(searchText.toLowerCase()) ||
                    item.subTitleLabel.getText().toLowerCase().contains(searchText.toLowerCase());
            item.setVisible(match);
            if (match) {
                searchArea.add(item);
            }
        }

        revalidate();
        repaint();
    }

}