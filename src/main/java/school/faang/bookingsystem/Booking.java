package school.faang.bookingsystem;

import lombok.Data;

@Data
public class Booking {
    private static int currentId = 1000;

    private int bookingId;
    private Room room;
    private String date;
    private String timeSlot;

    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = currentId++;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
