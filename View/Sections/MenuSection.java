package View.Sections;

import java.awt.Font;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;

import Model.Constants;
import Controller.FontLoader;
import View.Buttons.TTToggleButton;

public class MenuSection extends JPanel{

    private Font mainFont;
    private ButtonGroup bGroup;
    private MenuOptionsSection menuOptions;

    public MenuSection() {
        FontLoader fontLoader = new FontLoader();
        mainFont = fontLoader.loadFont(Constants.SYSTEM_FONT_PATH, 12f);
        bGroup = new ButtonGroup();
    }

    public void generateContent(MenuOptionsSection menuOptions) {

        // assign menuOptions so tjeu can be passed down to
        // each btn for control over the options below
        this.menuOptions = menuOptions;

        // create margins and remove stylings from container of buttons
        setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setOpaque(false);

        addOptions();
    }

    private void addOptions() {
        for (String s : Constants.MENU_OPTIONS) {
            generateButton(s);
        }
    }

    private void generateButton(String s) {
        TTToggleButton btn = new TTToggleButton(s, menuOptions);
        btn.setFont(mainFont);
        btn.setFocusPainted(false);

        // add button to the toggle group
        bGroup.add(btn);

        // add button to container display
        this.add(btn);

        // set the home button as selected for default behavior
        if (s.equals("Home")) btn.setSelected(true);

        // add blank space between buttons putting more space after the File button
        this.add(Box.createRigidArea(
            new Dimension((s.equals("File")?20:8),0)));
    }
}
