package hotels;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private List<BookingObserver> observers;

    public BookingNotifier() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }
}
