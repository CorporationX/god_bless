package school.faang.bjs2_68833;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> bookingObserverList = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        bookingObserverList.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        bookingObserverList.remove(observer);
    }

    public void notifyObserver(Booking booking, BookingStatus status) {
        for (BookingObserver observer : bookingObserverList) {
            observer.update(booking, status);
        }
    }
}

