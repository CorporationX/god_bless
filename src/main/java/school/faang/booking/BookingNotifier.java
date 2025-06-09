package school.faang.booking;

import lombok.extern.slf4j.Slf4j;
import school.faang.booking.domain.Booking;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Slf4j
public class BookingNotifier {

    private final Set<BookingObserver> bookingObservers = new HashSet<>();

    public void addObserver(BookingObserver observer) {
        bookingObservers.add(observer);
        log.info("Added observer: " + observer);
    }

    public void removeObserver(BookingObserver observer) {
        bookingObservers.remove(observer);
        log.info("Removed observer: " + observer);
    }

    public void notifyObservers(Booking booking, String status) {
        for (var observer : bookingObservers) {
            observer.update(booking, status);
            log.info("Notified observer: " + observer);
        }
    }
}
