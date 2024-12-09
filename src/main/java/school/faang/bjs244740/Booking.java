package school.faang.bjs244740;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
public class Booking {
    private final UUID bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = UUID.randomUUID();
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public boolean isLocked(int roomId, String date, String timeSlot) {
        return this.getDate().equals(date) && this.getTimeSlot().equals(timeSlot) && this.getRoom().getRoomId() == roomId;
    }
}
