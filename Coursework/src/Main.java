import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Table> tables_list = new ArrayList<>();
    static Menu_GUI menu;
    static Tables_GUI tables_menu;
    static Statistics_GUI statistics;

    public static void main(String[] args) {
        Table.tariff = 10;
        for (int i = 0; i < 10; i++) {
            tables_list.add(new Table());
        }
        menu = new Menu_GUI();
        tables_menu = new Tables_GUI();
        statistics = new Statistics_GUI();
        menu();
    }

    public static void menu() {
        menu = new Menu_GUI();
        menu.setResizable(false);
        menu.setVisible(true);
        tables_menu.setVisible(false);
        statistics.setVisible(false);
    }

    public static void tables_list() {
        tables_menu = new Tables_GUI();
        tables_menu.setResizable(false);
        menu.setVisible(false);
        tables_menu.setVisible(true);
        statistics.setVisible(false);
    }

    public static void statistics() {
        statistics = new Statistics_GUI();
        statistics.setResizable(false);
        menu.setVisible(false);
        tables_menu.setVisible(false);
        statistics.setVisible(true);
    }
}
