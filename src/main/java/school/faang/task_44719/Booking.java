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
    private int bookingId;
    private Room room;
    private String date;
    private String timeSlot;
}
