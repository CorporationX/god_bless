package school.faang.bjs244733;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Booking {

    private int bookingId;
    private Room room;
    private String date;
    private String timeSlot;

}
