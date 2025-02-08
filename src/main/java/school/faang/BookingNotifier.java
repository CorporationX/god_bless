package school.faang;

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
            throw new IllegalArgumentException("The observer can't be null");
        }
    }

    private void validateBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("The booking can't be null");
        }
    }

    private void validateStatus(String status) {
        if (status == null) {
            throw new IllegalArgumentException("The status can't be null");
        }
    }
}
