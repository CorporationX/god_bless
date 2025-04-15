package school.faang.stream1.bookingsystem;

import lombok.Getter;

@Getter
public class Booking {
    // — уникальный идентификатор бронирования;
    int bookingId;

    // — забронированная комната;
    Room room;

    // — дата бронирования;
    String date;

    // — временной интервал бронирования.
    String timeSlot;

    private static int lastBookingNumberHolder;

    public Booking(Room room, String date, String timeSlot) {
        this.bookingId = lastBookingNumberHolder++;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
