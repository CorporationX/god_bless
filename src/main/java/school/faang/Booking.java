package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Booking {
    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(int bookingId, Room room, String date, String timeSlot) {
        validateRoom(room);
        validateDate(date);
        validateTimeSlot(timeSlot);
        this.bookingId = bookingId;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    private void validateRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("The room can't be null");
        }
    }

    private void validateDate(String date) {
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("The type can't be null or blank");
        }
    }

    private void validateTimeSlot(String timeSlot) {
        if (timeSlot == null || timeSlot.isBlank()) {
            throw new IllegalArgumentException("The timeSlot can't be null or blank");
        }
    }
}
