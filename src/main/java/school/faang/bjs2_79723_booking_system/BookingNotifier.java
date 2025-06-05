package school.faang.bjs2_79723_booking_system;

import java.util.HashSet;

public class BookingNotifier {
    private static final HashSet<BookingObserver> OBSERVERS = new HashSet<>();

    public static void addObserver(BookingObserver observer) {
        OBSERVERS.add(observer);
    }

    public static void removeObserver(BookingObserver observer) {
        OBSERVERS.remove(observer);
    }

    public static void notifyObservers(Booking booking, String status) {
        OBSERVERS.forEach(observer -> observer.update(booking, status));
    }
}
