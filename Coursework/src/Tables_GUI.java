import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tables_GUI extends JFrame {
    public Tables_GUI() {
        super("Tables");
        int y_size = 900;
        int x_size = 600;
        this.setBounds(1920 / 2 - x_size / 2, 1080 / 2 - y_size / 2, x_size, y_size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 2));
        List<JButton> buttons = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            buttons.add(new JButton());
            if (Main.tables_list.get(i).is_available()) {
                buttons.get(i).setText("Cтол " + (i + 1) + " (Свободен)");
                buttons.get(i).setBackground(Color.GREEN);
            } else {
                sum += Main.tables_list.get(i).get_current_price();
                buttons.get(i).setText("Cтол " + (i + 1) + " (Занят) (" + Main.tables_list.get(i).get_current_time() + " мин. = " + Main.tables_list.get(i).get_current_price() + " руб.)");
                buttons.get(i).setBackground(Color.RED);
            }
            container.add(buttons.get(i));
            buttons.get(i).addActionListener(new table_button(i));
        }
        JButton back = new JButton("Вернуться в главное меню");
        container.add(back);
        back.addActionListener(new back());
        JTextField sum_text = new JTextField("общая сумма: " + sum + " руб.");
        container.add(sum_text);
    }

    static class table_button implements ActionListener {
        int i;

        public table_button(int index) {
            i = index;
        }

        public void actionPerformed(ActionEvent e) {
            if (Main.tables_list.get(i).is_available()) {
                Main.tables_list.get(i).new_session();
            } else {
                Main.tables_list.get(i).close_session();
            }
            Main.menu();
        }
    }

    static class back implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Main.menu();
        }
    }
}