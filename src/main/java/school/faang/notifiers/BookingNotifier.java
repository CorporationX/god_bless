package school.faang.notifiers;

import school.faang.exceptions.BookingValidationError;
import school.faang.exceptions.ObserverValidationError;
import school.faang.models.Booking;
import school.faang.interfaces.BookingObserver;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> observers = new ArrayList<>();

    public boolean addObserver(BookingObserver observer) {
        validateObserver(observer);
        if (observers.contains(observer)) {
            return false;
        }
        observers.add(observer);
        return true;
    }

    public boolean removeObserver(BookingObserver observer) {
        validateObserver(observer);
        if (!observers.contains(observer)) {
            return false;
        }
        observers.remove(observer);
        return true;
    }

    public void notifyObservers(Booking booking, String status) {
        validateBooking(booking);
        validateStatus(status);
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }

    private void validateObserver(BookingObserver observer) {
        if (observer == null) {
            throw new ObserverValidationError("The observer can't be null");
        }
    }

    private void validateBooking(Booking booking) {
        if (booking == null) {
            throw new BookingValidationError("The booking can't be");
        }
    }

    private void validateStatus(String status) {
        if (status == null) {
            throw new IllegalArgumentException("The status can't be null");
        }
    }
}
