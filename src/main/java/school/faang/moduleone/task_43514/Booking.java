package school.faang.moduleone.task_43514;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Booking {
    private int bookingId;
    private Room room;
    private String date;
    private String timeSlot;
}
