package school.faang.bookingmanagement;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * Related to JIRA ticket: BJS2-68742
 * */
@RequiredArgsConstructor
public class BookingNotifier {
    private final Set<BookingObserver> bookingObservers = new HashSet<>();

    public void addObserver(BookingObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer is null!");
        }
        bookingObservers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer is null!");
        }
        if (!bookingObservers.contains(observer)) {
            throw new NoSuchElementException("This observer is not in the collection!");
        }
        bookingObservers.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        if (booking == null || status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Illegal arguments!");
        }
        for (BookingObserver observer : bookingObservers) {
            observer.update(booking, status);
        }
    }
}
