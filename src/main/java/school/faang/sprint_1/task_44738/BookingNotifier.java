package school.faang.sprint_1.task_44738;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private final List<BookingObserver> bookingObservers = new ArrayList<>();

    public void addObserver(@NonNull BookingObserver observer) {
        bookingObservers.add(observer);
    }

    public void notifyObservers(@NonNull Booking booking, @NonNull String status) {
        bookingObservers.forEach(observer -> observer.update(booking, status));
    }
}
