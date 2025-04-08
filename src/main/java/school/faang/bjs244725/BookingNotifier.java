package school.faang.bjs244725;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private static final Logger logger = LoggerFactory.getLogger(BookingNotifier.class);

    private final List<BookingObserver> observers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
        logger.info("Observer added: {}", observer);
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
        logger.info("Observer removed: {}", observer);
    }

    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
            logger.info("Notified observer: {} with status: {}", observer, status);
        }
    }
}