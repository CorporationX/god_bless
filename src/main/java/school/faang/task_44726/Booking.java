package school.faang.task_44726;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Booking {
    private int bookingId;
    private Room room;
    private String date;
    private String timeSlot;

    private int currentMaxBookingId = 0;

    @Builder
    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = ++currentMaxBookingId;

        if (room == null) {
            throw new IllegalArgumentException("Room must be created and can not be null");
        }

        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("Booking date must be day of week");
        }

        if (timeSlot == null || timeSlot.isBlank()) {
            throw new IllegalArgumentException("Time slot must be number of day(s) :: '2d', '5d'");
        }

        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
