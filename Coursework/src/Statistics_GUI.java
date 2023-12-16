import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Statistics_GUI extends JFrame {
    public Statistics_GUI() {
        super("Statistics");
        int y_size = 1000;
        int x_size = 400;
        this.setBounds(1920 / 2 - x_size / 2, 1080 / 2 - y_size / 2, x_size, y_size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(55, 1));
        int amount_of_money_earned;
        int average_session_time;
        int number_of_sessions;
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            amount_of_money_earned = Main.tables_list.get(i).get_amount_of_money_earned();
            average_session_time = Main.tables_list.get(i).get_average_session_time();
            number_of_sessions = Main.tables_list.get(i).get_number_of_sessions();
            JTextField text1 = new JTextField("Стол " + (i + 1) + ":");
            JTextField text2 = new JTextField("Заработано " + (amount_of_money_earned) + " руб.");
            JTextField text3 = new JTextField("Занят по времени в среднем " + (average_session_time) + " мин.");
            JTextField text4 = new JTextField("Выбран " + (number_of_sessions) + " раз(a)");
            JTextField text5 = new JTextField(" ");
            container.add(text1);
            container.add(text2);
            container.add(text3);
            container.add(text4);
            container.add(text5);
            sum += amount_of_money_earned;
        }
        int max_amount_of_money_earned = -1;
        int table_max_amount_of_money_earned = -1;
        int max_number_of_sessions = -1;
        int table_max_number_of_sessions = -1;
        for (int i = 0; i < 10; i++) {
            if (Main.tables_list.get(i).get_amount_of_money_earned() > max_amount_of_money_earned) {
                max_amount_of_money_earned = Main.tables_list.get(i).get_amount_of_money_earned();
                table_max_amount_of_money_earned = i + 1;
            }
            if (Main.tables_list.get(i).get_number_of_sessions() > max_number_of_sessions) {
                max_number_of_sessions = Main.tables_list.get(i).get_number_of_sessions();
                table_max_number_of_sessions = i + 1;
            }
        }
        JTextField text1 = new JTextField("Всего заработано: " + sum + " руб.");
        JTextField text2 = new JTextField("Больше всего принёс в кассу столик " + table_max_amount_of_money_earned + " (" + max_amount_of_money_earned + " руб.)");
        JTextField text3 = new JTextField("Чаще всего выбирается столик " + table_max_number_of_sessions + " (" + max_number_of_sessions + " раз(a))");
        JTextField text4 = new JTextField(" ");
        container.add(text1);
        container.add(text2);
        container.add(text3);
        container.add(text4);
        JButton back = new JButton("Вернуться в главное меню");
        container.add(back);
        back.addActionListener(new back());
    }

    static class back implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Main.menu();
        }
    }
}
