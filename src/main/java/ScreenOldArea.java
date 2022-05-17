import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenOldArea {
    public static Rectangle area;
    static BufferedImage image;

    public static void newScreen() {
        if (area == null) {
            JFrame f = new JFrame("frame");
            Font f1 = new Font("TimesRoman", Font.TYPE1_FONT, 16);
            JLabel label = new JLabel("Выбирите область");
            label.setFont(f1);
            label.setBounds(10,10,120,30);
            f.add(label);
            f.setSize(170, 100);
            f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            f.setResizable(false);
            f.setVisible(true);
        }

    {
        try {
            image = new Robot().createScreenCapture(area);
            ImageIO.write(image, "png", new File("src/main/resources/screenshot.png"));
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}}
