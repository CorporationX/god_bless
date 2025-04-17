package school.faang.sprint_1.booking_system;

import java.util.List;

public class BookingNotifier {
    private List<BookingObserver> bookingObservers;

    public void addObserver(BookingObserver observer) {
        bookingObservers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        bookingObservers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        bookingObservers.forEach(observer -> observer.update(booking, status));
    }
}
