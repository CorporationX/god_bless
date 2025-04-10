package school.faang.booking;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Booking {
    private static int idCounter = 0;

    private final int bookingId = idCounter++;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(Room room, String date, String timeSlot) {
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
