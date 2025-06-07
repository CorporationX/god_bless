package school.faang.BJS2_79716;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
public class BookingSystem {
    private List<Room> roomList;

    private List<Booking> bookingList;

    private BookingNotifier bookingNotifier;

    public BookingSystem() {
        this.roomList = new ArrayList<>();
        this.bookingList = new ArrayList<>();
        this.bookingNotifier = new BookingNotifier();
    }

    public boolean addRoom(Room room) {
        if (roomList.contains(room)) {
            return false;
        }

        return roomList.add(room);
    }

    private boolean removeRoom(Room room) {
        return roomList.remove(room);
    }

    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        checkStringParameter(date, "date");
        checkStringParameter(timeSlot, "timeSlot");

        Room room = null;
        for (Room r : roomList) {
            if (r.getRoomNumber() == roomNumber) {
                room = r;
                break;
            }
        }

        if (room == null) {
            return null;
        }

        for (Booking booking : bookingList) {
            if (booking.getRoom().equals(room)) {
                return null;
            }
        }

        Booking booking = new Booking(room, date, timeSlot);
        if (!bookingList.add(booking)) {
            return null;
        }

        bookingNotifier.notifyObservers(booking, "BOOKED");
        return booking;
    }

    public boolean cancelBooking(int bookingId) {
        for (Booking booking : bookingList) {
            if (booking.getBookingId() == bookingId) {
                return bookingList.remove(booking);
            }
        }
        return false;
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        checkStringParameter(date, "date");
        checkStringParameter(timeSlot, "timeSlot");
        if (requiredAmenities == null) {
            requiredAmenities = new HashSet<>();
        }

        List<Room> availableRooms = new ArrayList<>();
        for (Room room : roomList) {
            boolean ok = true;
            for (String amenity : requiredAmenities) {
                if (!room.getAmenities().contains(amenity)) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                continue;
            }

            availableRooms.add(room);
        }

        for (Booking booking : bookingList) {
            if (!availableRooms.contains(booking.getRoom())) {
                continue;
            }

            if (date.equals(booking.getDate()) && timeSlot.equals(booking.getTimeSlot())) {
                availableRooms.remove(booking.getRoom());
            }
        }

        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        List<Booking> bookingForDate = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (date.equals(booking.getDate())) {
                bookingForDate.add(booking);
            }
        }

        return bookingForDate;
    }

    private void checkStringParameter(String arg, String name) {
        if (arg == null || arg.isBlank()) {
            throw new IllegalArgumentException(name + " can not to be null or empty");
        }
    }
}
