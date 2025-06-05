package school.faang.bjs2_79723_booking_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Booking {
    public static final String STATUS_CREATED = "created";
    public static final String STATUS_CANCELLED = "cancelled";

    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeslot;
}
