package school.faang.bjs244733;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {

    private final List<BookingObserver> observers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(Booking booking, Status status) {
        for (BookingObserver bookingObserver : observers) {
            bookingObserver.update(booking, status);
        }
    }


}
