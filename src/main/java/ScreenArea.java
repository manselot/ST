import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.imageio.ImageIO;
import javax.swing.*;

/** Getting a Rectangle of interest on the screen.
 Requires the MotivatedEndUser API - sold separately. */
public class ScreenArea {

    Rectangle captureRect;

    ScreenArea(final BufferedImage screen) throws AWTException, IOException {
        final BufferedImage screenCopy = new BufferedImage(
                screen.getWidth(),
                screen.getHeight(),
                screen.getType());
        final JLabel screenLabel = new JLabel(new ImageIcon(screenCopy));
        JScrollPane screenScroll = new JScrollPane(screenLabel);
        JFrame f = new JFrame("Button Example");
        f.setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        f.add(screenLabel);
        f.setUndecorated(true);
        f.setVisible(true);


        screenLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                f.dispose();
                try {
                    Answer.showWindow(Translate.translate());
                } catch (TesseractException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        screenLabel.addMouseMotionListener(new MouseMotionAdapter() {

            Point start = new Point();

            @Override
            public void mouseMoved(MouseEvent me) {
                start = me.getPoint();
                repaint(screen, screenCopy);
                screenLabel.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                Point end = me.getPoint();
                captureRect = new Rectangle(start,
                        new Dimension(end.x-start.x, end.y-start.y));
                repaint(screen, screenCopy);
                screenLabel.repaint();
                BufferedImage image = null;
                try {
                    image = new Robot().createScreenCapture(captureRect);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                try {
                    ImageIO.write(image, "png", new File("C:\\Users\\abuzer\\Desktop\\screenshot.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });





    }

    public void repaint(BufferedImage orig, BufferedImage copy) {
        Graphics2D g = copy.createGraphics();
        g.drawImage(orig,0,0, null);
        if (captureRect!=null) {
            g.setColor(Color.RED);
            g.draw(captureRect);
            g.setColor(new Color(255,255,255,25));
            g.fill(captureRect);
        }
        g.dispose();
    }

    public static void Screenarea() throws Exception {
        Robot robot = new Robot();
        final Dimension screenSize = Toolkit.getDefaultToolkit().
                getScreenSize();
        final BufferedImage screen = robot.createScreenCapture(
                new Rectangle(screenSize));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ScreenArea(screen);
                } catch (AWTException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}