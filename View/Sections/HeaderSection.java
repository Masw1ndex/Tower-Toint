package View.Sections;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JPanel;

public class HeaderSection extends JPanel{

    MenuSection menu;
    MenuOptionsSection menuOptions;

    public HeaderSection() {
        menu = new MenuSection();
        menuOptions = new MenuOptionsSection();
    }

    public void generateContent() {

        // set self-properties
        setPreferredSize(new Dimension(100,155));
        setLayout(new BorderLayout());
        setOpaque(false);

        // generate the 2 header sub-sections
        generateMenuOptions();
        generateMenu();

        // menu.provideOptionsListener(menuOptions);
    }

    private void generateMenu() {

        menu.generateContent(menuOptions);
        this.add(menu, BorderLayout.NORTH);
    }

    private void generateMenuOptions() {

        menuOptions.generateContent();
        this.add(menuOptions, BorderLayout.CENTER);
    }
}
