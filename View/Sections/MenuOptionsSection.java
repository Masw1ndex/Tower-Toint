package View.Sections;
import Model.Constants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.FontLoader;

public class MenuOptionsSection extends JPanel {

    private JLabel label;
    private Font btnFont;

    public void generateContent() {

        label = new JLabel("Menu");

        FontLoader fLoader = new FontLoader();
        btnFont = fLoader.loadFont(Constants.BTN_FONT_PATH, 12f);

        setBorder(BorderFactory.createEmptyBorder(2,20,2,8));
        setPreferredSize(new Dimension(200,120));
        setSize(new Dimension(200,120));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setOpaque(false);

        loadOptions();
    }

    private void loadOptions() {
        // add(label);

        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        // panel1.setOpaque(false);

        JLabel label1 = new JLabel("New Slide");

        String[] s = {"Header", "Blank", "Template"};

        for (String ss : s) {
            tempButtonLoad(panel1, ss);
        }

        panel1.add(label1);
        add(panel1);
    }

    private void tempButtonLoad(JPanel p, String s){
        JButton btn = new JButton(s);

        btn.setBorderPainted(false);
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setFont(btnFont);
        btn.setContentAreaFilled(false);
        btn.setPreferredSize(new Dimension(100,20));
        btn.setSize(new Dimension(100,20));

        p.add(btn);

        // add blank space between buttons putting more space after the File button
        p.add(Box.createRigidArea(
            new Dimension(0,5)));
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
