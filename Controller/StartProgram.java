package Controller;
import javax.swing.JFrame;

import Model.Constants;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class StartProgram {

    JFrame mainFrame;

    public StartProgram() {
        mainFrame = new JFrame("Tower Toint");
    }

    public void startProgram() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setMinimumSize(new Dimension(500, 300));

        MainDisplay display = new MainDisplay();
        display.setLayout(new BorderLayout());
        display.setBackground(Constants.PRIMARY_BACKGROUND_COLOR);
        display.initializeSections();

        mainFrame.add(display);
        mainFrame.setVisible(true);
    }
}
