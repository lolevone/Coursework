import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_GUI extends JFrame {
    public Menu_GUI() {
        super("Menu");
        int y_size = 300;
        int x_size = 300;
        this.setBounds(1920 / 2 - x_size / 2, 1080 / 2 - y_size / 2, x_size, y_size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 1));
        JButton tables_menu = new JButton("Список столов");
        JButton statistics_menu = new JButton("Статистика");
        container.add(tables_menu);
        container.add(statistics_menu);
        tables_menu.addActionListener(new tables_menu());
        statistics_menu.addActionListener(new statistics_menu());
    }

    static class tables_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Main.tables_list();
        }
    }

    static class statistics_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Main.statistics();
        }
    }
}