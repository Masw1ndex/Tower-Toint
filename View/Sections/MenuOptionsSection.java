package View.Sections;
import Model.Constants;
import View.Buttons.MenuOptionButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import Controller.FontLoader;

public class MenuOptionsSection extends JPanel {

    private JLabel label;
    private Font btnFont, lblFont;
    private String[] slideOptions = {"Cover", "Blank", "Content"};

    public void generateContent() {

        label = new JLabel("Menu");

        FontLoader fLoader = new FontLoader();
        btnFont = fLoader.loadFont(Constants.BTN_FONT_PATH, 16f);
        lblFont = fLoader.loadFont(Constants.LBL_FONT_PATH, 12f);

        setBorder(BorderFactory.createEmptyBorder(10,20,2,8));
        setPreferredSize(new Dimension(200,120));
        setSize(new Dimension(200,120));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setOpaque(false);

        loadOptions();
    }

    private void loadOptions() {

        loadSlideOptions();
        // loadTextOptions();
        // loadColorOptions();
    }

    private void loadSlideOptions() {

        MenuOptionButton btn;

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        panel.setPreferredSize(new Dimension(100,100));
        panel.setMaximumSize(new Dimension(100,100));
        panel.setOpaque(false);

        /*
            Create the buttons and apply the bottom border,
            but if last item, don't add the bottom border.

            Also, for the last 2 parameters, if the first index, indicate so, if last indicate so.
            This is used to apply rounded corners appropriately.
        */

        for (int i = 0; i<slideOptions.length; i++) {

            btn = new MenuOptionButton(
                100,
                25,
                slideOptions[i],
                (i==slideOptions.length-1?false:true),
                (i==0),
                (i==slideOptions.length-1)
            );

            btn.setFont(btnFont);
            panel.add(btn);
        }

        JLabel lbl = new JLabel("+ Slide");
        lbl.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        lbl.setForeground(Color.BLACK);
        lbl.setFont(lblFont);

        panel.add(lbl);
        add(panel);
        addSpacer();
    }

    private void addSpacer() {
        JPanel leftSideSpace = new JPanel();

        leftSideSpace.setBorder(new MatteBorder(0,0,0,1, Constants.PRIMARY_BACKGROUND_COLOR));
        leftSideSpace.setPreferredSize(new Dimension(15,100));
        leftSideSpace.setMaximumSize(new Dimension(15,100));
        leftSideSpace.setOpaque(false);

        JPanel rightSideSpace = new JPanel();

        rightSideSpace.setPreferredSize(new Dimension(15,100));
        rightSideSpace.setMaximumSize(new Dimension(15,100));
        rightSideSpace.setOpaque(false);

        add(leftSideSpace);
        add(rightSideSpace);
    }

    @SuppressWarnings("unused")
    private void loadTextOptions() {
    }

    @SuppressWarnings("unused")
    private void loadColorOptions() {
    }

    public void switchMenu(String s) {
        label.setText(s);
        // repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // set color of bar highlighted under button
        g2.setPaint(Constants.MENU_COLOR);
        g2.fillRoundRect(10, 6, getWidth()-20, getHeight()-12, 20, 20);

        g2.dispose();
        super.paintComponent(g);
    }

}
