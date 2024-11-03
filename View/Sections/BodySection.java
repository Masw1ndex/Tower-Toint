package View.Sections;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BodySection extends JPanel {

    ThumbnailSection thNails;
    SlideDisplaySection sDisplay;

    public BodySection() {
        thNails = new ThumbnailSection();
        sDisplay = new SlideDisplaySection();
    }

    public void generateContent() {

        // generate self-properties
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // generate content
        generateThumbnailSection(gbc);
        generateSlideDisplaySection(gbc);
    }

    private void generateThumbnailSection(GridBagConstraints gbc) {

        thNails.generateContent();

        // apply 15% width
        gbc.weightx = 0.15;

        //apply 100% height that is available to parent panel
        gbc.weighty = 1.0;

        // place left panel in column 0 (left)
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;

        // add left panel to the bottom panel with the above defined constraints
        this.add(thNails, gbc);
    }

    private void generateSlideDisplaySection(GridBagConstraints gbc) {

        sDisplay.generateContent();

        // place right panel in column 1 (right)
        gbc.gridx = 1;

        // apply 85% width to right panel
        gbc.weightx = 0.85;

        // apply right panel to bottom panel with the adjusted constraints
        this.add(sDisplay, gbc);
    }
}
