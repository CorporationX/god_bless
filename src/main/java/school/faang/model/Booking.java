package school.faang.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Booking {
    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;
}
