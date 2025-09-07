package school.faang.bjs2_85826;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookingNotifier implements BookingObserver {
    private List<BookingObserver> listBookingObserver = new ArrayList<>();

    public void addObserver(BookingObserver observer, String status) {
        listBookingObserver.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        listBookingObserver.remove(observer);
    }

    public void notifyObservers(Booking booking, String status) {
        for (int i = 0; i < listBookingObserver.size(); i++) {
            update(booking, status);
        }
    }

    @Override
    public void update(Booking booking, String status) {
        System.out.printf("There have been changes in room number %x \n" +
                          "status changed to %s", booking.getRoom().getRoomNumber(), status);
    }
}
