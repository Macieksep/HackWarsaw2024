import appElements.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppWin win = new AppWin("Vote Warsaw");

            CardLayout cardLayout = new CardLayout();
            JPanel sceneChanger = new JPanel(cardLayout);

            // OKNA
            JPanel mainMenuPanel = new MainMenuPanel(cardLayout, sceneChanger);
            JPanel donationPanel = new DonationMenuPanel(cardLayout, sceneChanger);
            JPanel pollCreatorPanel = new PollCreator(cardLayout, sceneChanger);

            // SCENY
            sceneChanger.add(mainMenuPanel, "MainMenu");
            sceneChanger.add(donationPanel, "Donation");
            sceneChanger.add(pollCreatorPanel, "PollCreator");

            // START SCENE
            win.add(sceneChanger);
            cardLayout.show(sceneChanger, "MainMenu");
            win.setVisible(true);
        });
    }
}
