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


    public Booking(int roomNumber, String date, String timeSlot) {

    }

}
