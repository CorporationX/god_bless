package school.faang;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Booking {
    private static final Logger logger = LoggerFactory.getLogger(Booking.class);

    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(int bookingId, Room room, String date, String timeSlot) {
        this.bookingId = bookingId;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
        logger.info("Booking created: {}", this);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", room=" + room +
                ", date='" + date + '\''
                + ", timeSlot='" + timeSlot + '\''
                + '}';
    }
}