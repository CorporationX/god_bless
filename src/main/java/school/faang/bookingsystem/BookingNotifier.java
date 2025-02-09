package school.faang.bookingsystem;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> bookingObserverList = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        if (!bookingObserverList.contains(observer)) {
            bookingObserverList.add(observer);
        } else {
            System.out.println("Observer already exists!\n");
        }
    }

    public void removeObserver(BookingObserver observer) {
        if (bookingObserverList.contains(observer)) {
            bookingObserverList.remove(observer);
        } else {
            System.out.println("Observer not exists!\n");
        }
    }

    protected void notifyObservers(Booking booking, String status) {
        bookingObserverList.forEach((observer) ->
                observer.updateObserver(booking, status));
    }
}
