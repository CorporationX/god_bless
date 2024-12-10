package school.faang.task_44715;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private static List<BookingObserver> bookingObserverList = new ArrayList<BookingObserver>();

    public void addObserver(BookingObserver observer) {
        bookingObserverList.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        bookingObserverList.removeIf(currObserver -> currObserver.equals(observer));
    }

    public static void notifyObservers(Booking booking, String status) {
        bookingObserverList.forEach(observer -> observer.update(booking, status));
    }
}
