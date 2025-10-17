package school.faang.bjs2_85826;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Booking {
    public static final int DEFUAL_ID = 0;
    private int bookingId = DEFUAL_ID;
    private Room room;
    private String date;
    private String timeSlot;
}
