package school.faang.task_44723;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import school.faang.task_44723.model.Booking;
import school.faang.task_44723.model.BookingStatus;

import java.util.HashSet;
import java.util.Set;

@Getter
public class BookingNotifier {
    private final Set<BookingObserver> bookingObservers = new HashSet<>();

    public void addObserver(@NotNull BookingObserver observer) {
        bookingObservers.add(observer);
    }

    public void removeObserver(@NotNull BookingObserver observer) {
        bookingObservers.remove(observer);
    }

    public void notifyObservers(
            @NotNull Booking booking,
            @NotNull BookingStatus status
    ) {
        bookingObservers.forEach(observer -> {
            observer.update(booking, status);
        });
    }
}
