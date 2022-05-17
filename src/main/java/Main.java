import net.sourceforge.tess4j.TesseractException;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        showWindow();
    }
    public static void showWindow() {
        Config.readConfig();
        String[] aboba = Config.setConfig();
        JFrame f = new JFrame("ST");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton select_area = new JButton("Select area");
        JButton translate = new JButton("Translate");
        JButton settings = new JButton("Settings");
        select_area.setBounds(0, 0, 120, 30);
        translate.setBounds(120, 0, 120, 30);
        settings.setBounds(240, 0, 120, 30);
        select_area.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               f.setState(JFrame.ICONIFIED);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    ScreenArea.Screenarea();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        translate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ScreenOldArea.newScreen();
                    Answer.showWindow(Translate.translate());
                } catch (TesseractException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.setView();
            }
        });
        Action action = new AbstractAction("Settings") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ScreenOldArea.newScreen();
                    Answer.showWindow(Translate.translate());
                } catch (TesseractException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(aboba[1].toUpperCase(Locale.ROOT)));
        settings.setAction(action);
        settings.getActionMap().put("pressed", action);
        settings.getInputMap(JComponent.WIDTH).put(
                (KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "pressed");
        Action action1 = new AbstractAction("Select area") {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setState(JFrame.ICONIFIED);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    ScreenArea.Screenarea();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        action1.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(aboba[0].toUpperCase()));
        select_area.setAction(action1);
        select_area.getActionMap().put("pressed", action1);
        select_area.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action1.getValue(Action.ACCELERATOR_KEY), "pressed");
        f.add(select_area);
        f.add(translate);
        f.add(settings);
        f.setSize(376, 69);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
    }
}
