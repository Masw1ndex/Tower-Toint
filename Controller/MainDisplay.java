package Controller;
import java.awt.BorderLayout;

import javax.swing.JPanel;

import Model.Constants;
import View.Sections.BodySection;
import View.Sections.HeaderSection;

public class MainDisplay extends JPanel {

    HeaderSection header;
    BodySection body;

    public void initializeSections() {

        setBackground(Constants.PRIMARY_BACKGROUND_COLOR);

        // generate primary areas within ancestor JPanel
        generateHeaderSection();
        generateBodySection();

        // add primary areas to the ancestor JPanel
        this.add(header, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
    }

    private void generateHeaderSection() {

        // create top section to be a fixed height
        header = new HeaderSection();
        header.generateContent();
    }

    private void generateBodySection() {

        // create bottom section to be a flexible height and width
        // this will need a GridBagLayout to have flexible height and width depending on window size for internal components
        body = new BodySection();
        body.generateContent();

    }
}
