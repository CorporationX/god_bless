package school.faang.task_44808.booking.domain.observer;

import school.faang.task_44808.booking.domain.enumeration.BookingStatus;
import school.faang.task_44808.booking.domain.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> observers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(observer);
    }

    public void notifyObservers(Booking booking, BookingStatus status) {
        observers.forEach(observer -> observer.update(booking, status));
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }
}
