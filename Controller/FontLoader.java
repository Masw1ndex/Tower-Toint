package Controller;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import java.io.File;
import java.io.IOException;

public class FontLoader {

    public Font loadFont(String fontPath, float size) {

        // grab primary font
        try {
            File fontFile = new File(fontPath);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
            return font;
        } catch (IOException | FontFormatException e) {
            System.out.println("Could not load font: " + e.getMessage());
            return null;
        }
    }
}
