package school.faang.task_44736;

import lombok.Getter;

@Getter
public class Booking {
    private int bookingId;
    private Room room;
    private String date;
    private String timeSlot;
    private static int idCounter;

    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = ++idCounter;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
