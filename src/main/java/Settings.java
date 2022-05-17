import javax.swing.*;
import java.awt.event.*;

public class Settings {
    public static void print() {
        System.out.println("aboba");
    }

    public static void setView() {
        JFrame f = new JFrame("frame");
        JLabel label = new JLabel("Выберать область: ");
        JLabel a = new JLabel("Перевести: ");
        JLabel b = new JLabel("Горячие клавиши ");
        b.setBounds(10,0,120,30);
        JButton save = new JButton("Сохранить");
        JButton exit = new JButton("Отмена");
        save.setBounds(115,125,100,25);
        exit.setBounds(225,125,100,25);
        String[] aboba = Config.setConfig();
        JTextField bind1 = new JTextField(aboba[0]);
        JTextField bind2 = new JTextField(aboba[1]);
        bind1.setBounds(138,39,120,25);
        bind2.setBounds(138,74,120,25);
        JLabel label2 = new JLabel("");
        f.setSize(350, 200);
        f.add(save);
        f.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.changeConfigArea(bind1.getText());
                Config.changeConfigTrans(bind2.getText());
                f.dispose();
            }
        });
        bind1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char symvol = e.getKeyChar();
                bind1.setText((""));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                char symvol = e.getKeyChar();
                bind1.setText(String.valueOf(symvol));
            }
        });
        bind2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char symvol = e.getKeyChar();
                bind1.setText((""));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                char symvol = e.getKeyChar();
                bind1.setText(String.valueOf(symvol));
            }
        });
        label.setBounds(20,35 ,120,30);
        a.setBounds(65,70 ,120,30);
        f.add(b);
        f.add(label);
        f.add(a);
        f.add(bind2);
        f.add(bind1);
        f.add(label2);
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }
}
