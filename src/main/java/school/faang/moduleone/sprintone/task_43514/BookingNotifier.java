package school.faang.moduleone.sprintone.task_43514;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BookingNotifier {
    private final List<BookingObserver> observers;

    public boolean addObserver(BookingObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(BookingObserver observer) {
        return observers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        for (BookingObserver observer : observers) {
            observer.update(booking, status);
        }
    }

}
