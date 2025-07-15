package school.faang.organization_system;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier implements BookingObserver {
    private List<BookingObserver> bookingObservers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        bookingObservers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        bookingObservers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver bookingObserver : bookingObservers) {
            bookingObserver.update(booking, status);
        }
    }

    @Override
    public void update(Booking booking, String status) {
        System.out.println("Комната " + booking.getRoom().getRoomNumber() + " " + status);
    }
}
