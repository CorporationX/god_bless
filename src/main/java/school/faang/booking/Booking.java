package school.faang.booking;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Booking {
    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;
}