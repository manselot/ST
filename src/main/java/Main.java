import net.sourceforge.tess4j.TesseractException;

import javax.swing.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        showWindow();
    }
    public static void showWindow() {
        JFrame f = new JFrame("Button Example");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton select_area = new JButton("Select area");
        JButton translate = new JButton("Translate");
        JButton settings = new JButton("Settings");
        JLabel label = new JLabel("");
        label.setBounds(125,125,200,200);
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
                    Answer.showWindow(Translate.translate());
                } catch (TesseractException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        f.setBounds(100 ,100,100,100);
        f.add(select_area);
        f.add(translate);
        f.add(settings);
        f.add(label);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
