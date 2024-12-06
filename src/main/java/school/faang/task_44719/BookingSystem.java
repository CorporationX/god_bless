package school.faang.task_44719;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookingSystem {
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();
    private final BookingNotifier notifier;
    private int nextBookingId;

    public BookingSystem(BookingNotifier notifier) {
        this.notifier = notifier;
        nextBookingId = 0;
    }

    public boolean addRoom(Room room) {
        if (!rooms.containsKey(room.getRoomId())) {
            rooms.put(room.getRoomId(), room);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeRoom(int roomId) {
        if (rooms.containsKey(roomId)) {
            rooms.remove(roomId);
            return true;
        } else {
            return false;
        }
    }

    public Booking bookRoom(int roomId, String date, String timeSlot) {
        Room room = rooms.get(roomId);
        if (room == null || !isRoomAvailable(room, date, timeSlot)) {
            return null;
        }
        Booking booking = new Booking(nextBookingId++, room, date, timeSlot);
        bookings.put(booking.getBookingId(), booking);
        notifier.notifyObservers(booking, BOOKING_STATUS.CREATED);
        return booking;
    }

    public boolean cancelBooking(int bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking != null) {
            notifier.notifyObservers(booking, BOOKING_STATUS.CANCELLED);
            return true;
        }
        return false;
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        if (requiredAmenities != null) {
            for (Room room : rooms.values()) {
                if (isRoomAvailable(room, date, timeSlot) && room.getAmenities().containsAll(requiredAmenities)) {
                    availableRooms.add(room);
                }
            }
        }
        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        List<Booking> bookingsForDate = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getDate().equals(date)) {
                bookingsForDate.add(booking);
            }
        }
        return bookingsForDate;
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot) {
        for (Booking booking : bookings.values()) {
            if (booking.getRoom().equals(room) && booking.getDate().equals(date)
                    && booking.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }
}
