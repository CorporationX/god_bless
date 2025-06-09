package school.faang.booking.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Data
public class Booking {

    private final int id;
    private final Room room;
    private final String date;
    private final String timeSlot;
}
