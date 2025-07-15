package school.faang.organization_system;

import lombok.Data;

@Data
public class Booking {
    private static int countBooking = 0;
    private int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(Room room, String date, String timeSlot, int bookingId) {
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
        this.bookingId = ++countBooking;
    }
}
