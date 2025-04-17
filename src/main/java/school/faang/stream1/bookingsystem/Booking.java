package school.faang.stream1.bookingsystem;

import lombok.Getter;

@Getter
public class Booking {
    private final int bookingId;

    private final Room room;

    private final String date;

    private final String timeSlot;

    private static int lastBookingNumberHolder;

    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = lastBookingNumberHolder++;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
