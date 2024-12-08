package school.faang.task_44729;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookingSystem {
    private int nextBookingId = 1;

    private final Map<Integer, Room> rooms;
    private final Map<Integer, Booking> bookings;

    private final BookingNotifier notifier;

    public BookingSystem() {
        this.rooms = new HashMap<>();
        this.bookings = new HashMap<>();
        this.notifier = new BookingNotifier();
    }

    public void addRoom(Room room) {
        if (!rooms.containsKey(room.roomId())) {
            rooms.put(room.roomId(), room);
        } else {
            System.out.printf("Room with ID %d already exists.%n", room.roomId());
        }
    }

    public void removeRoom(int roomId) {
        if (rooms.containsKey(roomId)) {
            Room room = rooms.remove(roomId);
            System.out.printf("%s has been removed successfully.%n", room);
        } else {
            System.out.printf("Room with ID %d not found.%n", roomId);
        }
    }

    public void bookRoom(int roomId, String date, String timeSlot) {
        Room room = rooms.get(roomId);
        if (room == null || !isRoomAvailable(room, date, timeSlot)) {
            return;
        }
        Booking booking = new Booking(nextBookingId++, room, date, timeSlot);
        bookings.put(booking.bookingId(), booking);
        notifier.notifyObservers(booking, "created");
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking != null) {
            notifier.notifyObservers(booking, "cancelled");
            System.out.printf("%s%n\thas been cancelled successfully.%n", booking);
        } else {
            System.out.printf("Booking with ID %d not found.%n", bookingId);
        }
    }

    public void findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (isRoomAvailable(room, date, timeSlot) && room.amenities().containsAll(requiredAmenities)) {
                availableRooms.add(room);
            }
        }
        System.out.printf("%s %s %s%n", date, timeSlot, requiredAmenities);
        System.out.printf("Available rooms%n");
        availableRooms.forEach(room -> System.out.printf("\t- %s%n", room));
    }

    public void findBookingsForDate(String date) {
        List<Booking> bookingsForDate = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.date().equals(date)) {
                bookingsForDate.add(booking);
            }
        }
        System.out.printf("findBookingForDate - %s:%n", date);
        bookingsForDate.forEach(booking -> System.out.printf("\t- %s%n", booking));
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot) {
        for (Booking booking : bookings.values()) {
            if (booking.room().equals(room)
                    && booking.date().equals(date)
                    && booking.timeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }

}
