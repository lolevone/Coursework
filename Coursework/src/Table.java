import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Table {
    protected static int tariff;
    private final List<List<Integer>> sessions = new ArrayList<>();
    public boolean availability = true;
    private final Clock clock = Clock.systemUTC();
    private LocalTime start_time = LocalTime.now(clock);

    public void new_session() {
        LocalTime time = LocalTime.now(clock);
        availability = false;
        start_time = time;
    }

    public void close_session() {
        LocalTime time = LocalTime.now(clock);
        availability = true;
        sessions.add(List.of((int) (MINUTES.between(start_time, time) + 1), ((int) (MINUTES.between(start_time, time) + 1) * tariff)));
    }

    public boolean is_available() {
        return availability;
    }

    public int get_current_time() {
        LocalTime time = LocalTime.now(clock);
        return (int) MINUTES.between(start_time, time);
    }

    public int get_current_price() {
        LocalTime time = LocalTime.now(clock);
        return ((int) (MINUTES.between(start_time, time) + 1) * tariff);
    }

    public int get_number_of_sessions() {
        return sessions.size();
    }

    public int get_average_session_time() {
        if (!sessions.isEmpty()) {
            int result = 0;
            for (List<Integer> session : sessions) {
                result += session.get(0);
            }
            result = Math.round((float) result / sessions.size());
            return result;
        } else {
            return 0;
        }
    }

    public int get_amount_of_money_earned() {
        if (!sessions.isEmpty()) {
            int result = 0;
            for (List<Integer> session : sessions) {
                result += session.get(1);
            }
            return result;
        } else {
            return 0;
        }
    }
}