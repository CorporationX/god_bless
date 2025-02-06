package school.faang.observer;

import school.faang.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> observers = new ArrayList<>();

    /**
     * Adds an observer to the notifier.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the notifier.
     *
     * @param observer The observer to be removed.
     */
    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about a booking update.
     *
     * @param booking The booking instance.
     * @param status  The status of the booking (e.g., Booked, Cancelled).
     */
    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }
}
