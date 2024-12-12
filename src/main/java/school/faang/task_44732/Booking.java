package school.faang.task_44732;

import lombok.Getter;

@Getter
public class Booking {
    private int bookingId;
    private Room room;
    private String date;
    private String timeSlot;

    public Booking(int bookingId, Room room, String date, String timeSlot) {
        this.bookingId = bookingId;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
