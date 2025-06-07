package school.faang.BJS2_79716;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private List<BookingObserver> bookingObserverList;

    public BookingNotifier() {
        this.bookingObserverList = new ArrayList<>();
    }

    public boolean addObserver(BookingObserver observer) {
        if (bookingObserverList.contains(observer)) {
            return false;
        }

        return bookingObserverList.add(observer);
    }

    public boolean removeObserver(BookingObserver observer) {
        return bookingObserverList.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        bookingObserverList.stream().forEach(observer -> observer.update(booking, status));
    }
}
