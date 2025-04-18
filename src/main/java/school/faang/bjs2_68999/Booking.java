package school.faang.bjs2_68999;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Booking {
    private static int counter = 0;
    private final int bookingId;
    private Room room;
    private String date;
    private int timeSlot; // отступление от задачи, количество дней бронирования

    public Booking(Room room, String date, int timeSlot) {
        this.bookingId = ++counter;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
