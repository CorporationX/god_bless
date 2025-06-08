package school.faang.bjs2_79723_booking_system.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import school.faang.bjs2_79723_booking_system.room.Room;

@AllArgsConstructor
@Getter
@ToString
public class Booking {
    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeslot;
}
