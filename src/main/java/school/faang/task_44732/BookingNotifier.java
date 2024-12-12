package school.faang.task_44732;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BookingNotifier {
    private final List<BookingObserver> observers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
        log.info("Observer added: {}", observer.getClass().getSimpleName());
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
        log.info("Observer removed: {}", observer.getClass().getSimpleName());
    }

    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }
}
