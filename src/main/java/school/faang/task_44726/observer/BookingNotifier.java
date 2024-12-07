package school.faang.task_44726.observer;

import school.faang.task_44726.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private List<BookingObserver> bookingObserver = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        bookingObserver.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        bookingObserver.remove(observer);
    }


    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : bookingObserver) {
            observer.update(booking, status);
        }
    }
}