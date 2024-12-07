package school.faang.task_44736;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Administrator implements BookingObserver {
    private String name;

    @Override
    public void update(Booking booking, String status) {
        System.out.println("Hello, " + name + " this room " + booking.getRoom().getRoomId()
                + " " + status);
    }
}
