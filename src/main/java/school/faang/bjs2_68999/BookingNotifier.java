package school.faang.bjs2_68999;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class BookingNotifier {
    private static List<BookingObserver> observers = new ArrayList<>();
    
    public static void addObserver(BookingObserver observer) {
        observers.add(observer);
    }
    
    public static void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    public static void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }

    public static List<BookingObserver> getObservers() {
        return BookingNotifier.observers;
    }
}
