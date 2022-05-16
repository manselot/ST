import javax.swing.*;
import java.awt.*;

public class Answer {
    public static void showWindow(String text) {
        JFrame f = new JFrame("frame");
        f.setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(1, 1)); //assign gridlayout so text area fills panel
        JTextArea t2 = new JTextArea(5, 30);
        t2.setText(text);

        JScrollPane scrollPane = new JScrollPane(t2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(scrollPane);
        t2.setLineWrap(true);
        f.add(p, BorderLayout.CENTER); //place text area panel in center position


        f.setSize(600, 500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
