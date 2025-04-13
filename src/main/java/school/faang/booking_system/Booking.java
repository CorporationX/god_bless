package school.faang.booking_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Booking {
    private Integer bookingId;
    private Room room;
    private String date;
    private String timeSlot;
}
