package school.faang.organization_system;

public class Bookingld {
    private int countBooking = 0;
    private int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Bookingld(Room room, String date, String timeSlot, int bookingId) {
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
        this.bookingId = ++countBooking;
    }
}
