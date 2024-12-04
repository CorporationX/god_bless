package school.faang.task_43514;

import school.faang.task_43514.enums.BookingStatus;
import school.faang.task_43514.model.Booking;

import java.util.HashSet;
import java.util.Set;

public class BookingNotifier {
    Set<BookingObserver> observers = new HashSet<>();

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
