package school.faang.bjs244740;

import school.faang.bjs244740.observers.BookingObserver;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> observers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        observers.forEach(observer -> observer.update(booking, status));
    }
}
