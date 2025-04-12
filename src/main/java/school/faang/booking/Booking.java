package school.faang.booking;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@EqualsAndHashCode
@ToString
public class Booking {
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = idCounter.getAndIncrement();
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
