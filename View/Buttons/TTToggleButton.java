package View.Buttons;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

import Model.Constants;
import View.Sections.MenuOptionsSection;

public class TTToggleButton extends JToggleButton {

    private boolean onHover = false;
    private MenuOptionsSection menuOptions;

    public TTToggleButton(String s, MenuOptionsSection menuOptions) {

        super(s);

        this.menuOptions = menuOptions;

        // clear out stylings for button
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);

        // set margins for button and text color to white
        setBorder(BorderFactory.createEmptyBorder(0,6,4,6));
        setForeground(Color.WHITE);

        // use mouse listeners to add hover effects to a button
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                onHover = true;
                repaint();
            }
            public void mouseExited(MouseEvent evt) {
                onHover = false;
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        if (onHover) {

            // if the options is already selected on on hover,
            // make the bar get a little bigger
            if (isSelected()) {
                g2.setPaint(Constants.BUTTON_ACCENT_COLOR);
                g2.fillRect(0, getHeight()-3, getWidth(), 3);
            } else {
                // set color of bar highlighted under button
                g2.setPaint(Constants.BUTTON_HOVER_COLOR);
                g2.fillRect(0, getHeight()-3, getWidth(), 4);
            }

        }

        if (isSelected()) {
            // set color of bar highlighted under button
            g2.setPaint(Constants.BUTTON_ACCENT_COLOR);
            g2.fillRect(3, getHeight()-3, getWidth()-6, 3);

            // let the parent of the toggle button know that a new button has been selected
            menuOptions.switchMenu(getText());
        }

        g2.dispose();

        super.paintComponent(g);
    }
}
