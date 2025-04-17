package school.faang.sprint_1.booking_system;

import lombok.Getter;

@Getter
public class Booking {
    private Integer bookingId = 0;
    private Room room;
    private String date;
    private String timeSlot;

    public Booking(Room room, String date, String timeSlot) {
        bookingId++;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
