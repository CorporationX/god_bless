package school.faang.task_44750;

public class Booking {
    private final int bookingId;
    private final Room room;
    private final String date;
    private final String timeSlot;

    public Booking(int bookingId, Room room, String date, String timeSlot) {
        this.bookingId = bookingId;
        this.room = room;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public String getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Booking{"
                + "bookingId=" + bookingId
                + ", room=" + room
                + ", date='" + date + '\''
                + ", timeSlot='" + timeSlot + '\''
                + '}';
    }
}
