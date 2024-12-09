package school.faang.moduleone.task_43514;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> observers = new ArrayList<>();

    public boolean addObserver(BookingObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(BookingObserver observer) {
        return observers.remove(observer);
    }

    void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }

}
