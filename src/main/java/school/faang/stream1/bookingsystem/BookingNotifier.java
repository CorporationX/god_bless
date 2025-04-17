package school.faang.stream1.bookingsystem;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> observers;

    public boolean addObserver(BookingObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(BookingObserver observer) {
        return observers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        observers.forEach(bookingObserver -> bookingObserver.update(booking, status));
    }

    public BookingNotifier() {
        this.observers = new ArrayList<>();
    }
}
