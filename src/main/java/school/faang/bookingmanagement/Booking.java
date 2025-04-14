package school.faang.bookingmanagement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(of = "bookingId")
public class Booking {
    private static int idCounter = 0;

    private final int bookingId = ++idCounter;
    @Setter
    private Room room; // комнату можно изменить
    private final LocalDate date;
    private final TimeSlot timeSlot; // временной интервал бронирования.
    private final List<Booking> bookings = new ArrayList<>();

    public Booking(Room room, String date, String timeSlot) {
        this.room = room;
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.timeSlot = TimeSlot.getTimeSlotFromString(timeSlot);
        bookings.add(this);
    }
}