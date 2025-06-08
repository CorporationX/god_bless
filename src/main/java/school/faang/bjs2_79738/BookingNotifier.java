package school.faang.bjs2_79738;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BookingNotifier {
    private final List<BookingObserver> bookingObservers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        if (!bookingObservers.contains(observer)) {
            bookingObservers.add(observer);
        } else {
            log.info("Observer already exists: {}", observer);
        }
    }

    public void removeObserver(BookingObserver observer) {
        if (!bookingObservers.contains(observer)) {
            log.info("observer not exists: {}", observer);
        } else {
            bookingObservers.remove(observer);
            log.info("observer deleted: {}", observer);
        }
    }

    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : bookingObservers) {
            observer.update(booking, status);
        }
    }
}