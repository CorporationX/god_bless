package school.faang.task_44719;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Booking {
    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;
}
