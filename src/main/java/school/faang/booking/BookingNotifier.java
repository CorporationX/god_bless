package school.faang.booking;

import school.faang.booking.observer.BookingObserver;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> observers = new ArrayList<>();

    public BookingObserver addObserver(BookingObserver observer) {
        observers.add(observer);
        return observer;
    }

    public boolean removeObserver(BookingObserver observer) {
        return observers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        observers.forEach(observer -> observer.update(booking, status));
    }
}