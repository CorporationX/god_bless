package school.faang.bookingmanagement;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Related to JIRA ticket: BJS2-68742
 * */
@Getter
public class Booking {
    private static int idCounter = 0;

    private final int bookingId = ++idCounter;
    @Setter
    private Room room; // комнату можно изменить
    private final String date;
    private final String timeSlot; // временной интервал бронирования.
    private final List<Booking> bookings = new ArrayList<>();

    public Booking(Room room, String date, String timeSlot) {
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
        bookings.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }
}
