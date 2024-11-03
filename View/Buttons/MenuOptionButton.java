package View.Buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import Model.Constants;

public class MenuOptionButton extends JButton {

    private boolean onHover = false, clicked = false;
    private boolean isFirst, isLast;

    public MenuOptionButton(int width, int height, String s, boolean bottomBorder, boolean isFirst, boolean isLast) {
        super(s);

        this.isFirst = isFirst;
        this.isLast = isLast;

        setPreferredSize(new Dimension(width, height));
        setBorder(null);
        setFocusPainted(false);
        setLayout(null);
        setContentAreaFilled(false);

        if (bottomBorder) {
            setBorder(new MatteBorder(0,0,1,0, Color.BLACK));
        }

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

            public void mousePressed(MouseEvent evt) {
                clicked = true;
                repaint();
            }

            public void mouseReleased(MouseEvent evt) {
                clicked = false;
                repaint();
            }
        });

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        if (onHover) {

            // if the button is being hovered set one color, if hovering and pressing mouse down, set other color
            g2.setPaint((clicked?Constants.MENU_OPTION_BUTTON_CLICKED_COLOR:Constants.MENU_OPTION_BUTTON_HOVER_COLOR));

            /*
                if the button is first in the list apply rounded corners to top
                if the button is a middle option, ignore corners
                if the button is a bottom option apply rounded corners to bottom
                this behavior is technically acheived by making the box bigger and shifting it outside the bounds of the box
            */
            if (!isFirst && !isLast){
                g2.fillRect(0, 0, getWidth(), getHeight());
            } else if (isFirst) {
                g2.fillRoundRect(0, 0, getWidth(), getHeight()+10, 10, 10);
            } else {
                g2.fillRoundRect(0, -10, getWidth(), getHeight()+10, 10, 10);
            }
        }

        g2.dispose();
        super.paintComponent(g);
    }

}
