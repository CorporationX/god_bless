package school.faang.BJS2_79716;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Booking {
    private static int counter;

    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = ++counter;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
