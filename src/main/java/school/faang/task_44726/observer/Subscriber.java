package school.faang.task_44726.observer;

import lombok.Builder;
import lombok.ToString;
import school.faang.task_44726.Booking;

@ToString
@Builder
public class Subscriber implements BookingObserver {

    private String name;

    @Override
    public void update(Booking booking, String status) {
        System.out.println("\n"+ name + " received new message.");
        System.out.println("The booking: " + booking + " changed status to: " + status);
    }
}
