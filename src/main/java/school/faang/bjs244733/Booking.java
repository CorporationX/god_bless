package school.faang.bjs244733;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class Booking {

    private int bookingId;// — уникальный идентификатор бронирования;
    private Room room;// — забронированная комната;
    private String date;// — дата бронирования;
    private String timeSlot;// — временной интервал бронирования.

}
