package school.faang.bookingsystem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Booking {
    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;
}
