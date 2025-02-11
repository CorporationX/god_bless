package school.faang.bookingsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BookingNotifier {
    private final List<BookingObserver> bookingObserverList = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        if (!bookingObserverList.contains(observer)) {
            bookingObserverList.add(observer);
        } else {
            log.info("{} already added to the list", observer);
        }
    }

    public void removeObserver(BookingObserver observer) {
        if (bookingObserverList.contains(observer)) {
            bookingObserverList.remove(observer);
        } else {
            log.info("{} no exists", observer);
        }
    }

    protected void notifyObservers(Booking booking, String status) {
        bookingObserverList.forEach((observer) ->
                observer.updateObserver(booking, status));
    }
}
