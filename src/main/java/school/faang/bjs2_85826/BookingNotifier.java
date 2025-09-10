package school.faang.bjs2_85826;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookingNotifier {
    private List<BookingObserver> listBookingObserver = new ArrayList<>();

    public void addObserver(BookingObserver observer, String status) {
        listBookingObserver.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        listBookingObserver.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        listBookingObserver.forEach(obs -> obs.update(booking, status));
    }

}
