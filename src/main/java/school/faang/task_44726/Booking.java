package school.faang.task_44726;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Builder
@Getter
public class Booking {
    private UUID bookingId;
    private int roomId;
    private String date;
    private String timeSlot;
}
