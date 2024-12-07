package school.faang.task_44721;

import school.faang.task_44721.enums.BookingStatus;
import school.faang.task_44721.model.Booking;

import java.util.HashSet;
import java.util.Set;

public class BookingNotifier {
    private final Set<BookingObserver> observers = new HashSet<>();

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Booking booking, BookingStatus status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }
}
