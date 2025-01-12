package school.faang.task_44808.booking.domain.model;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.booking.domain.timeslot.BookingDate;
import school.faang.task_44808.booking.domain.timeslot.BookingTime;
import school.faang.task_44808.room.domain.model.Room;

@Slf4j
@Getter
@ToString
public class Booking {
    private final int id;
    private final Room room;
    private final BookingDate date;
    private final BookingTime timeSlot;

    Booking(int id, Room room, BookingDate date, BookingTime timeSlot) {
        this.id = id;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;

        log.debug("Created booking: id={}, room={}, date={}, timeSlot={}", id, room, date, timeSlot);
    }
}
