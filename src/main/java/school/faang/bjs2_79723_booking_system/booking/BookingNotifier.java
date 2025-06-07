package school.faang.bjs2_79723_booking_system.booking;

import school.faang.bjs2_79723_booking_system.observer.BookingObserver;

import java.util.HashSet;

public class BookingNotifier {
    private static final HashSet<BookingObserver> OBSERVERS = new HashSet<>();

    public void addObserver(BookingObserver observer) {
        OBSERVERS.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        OBSERVERS.remove(observer);
    }

    public void notifyObservers(Booking booking, BookingStatus status) {
        OBSERVERS.forEach(observer -> observer.update(booking, status));
    }
}
