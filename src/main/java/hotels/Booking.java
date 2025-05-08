package hotels;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Booking {
    @NonNull
    private Integer bookingId;
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
