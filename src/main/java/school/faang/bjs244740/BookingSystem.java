package school.faang.bjs244740;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Getter
public class BookingSystem {
    private final Map<UUID, Booking> bookings = new HashMap<>();
    private final Map<Integer, Room> rooms = new HashMap<>();

    @Getter
    private final BookingNotifier bookingNotifier = new BookingNotifier();

    public void addRoom(Room room) throws IllegalArgumentException {
        if (rooms.containsKey(room.getRoomId())) {
            throw new IllegalArgumentException("Room with id " + room.getRoomId() + " already exists");
        }
        rooms.put(room.getRoomId(), room);
    }

    public void removeRoom(int roomId) {
        rooms.remove(roomId);
    }

    public Booking bookRoom(int roomId, String date, String timeSlot) throws IllegalArgumentException {
        if (bookings.values().stream().anyMatch(b -> b.isLocked(roomId, date, timeSlot))) {
            throw new IllegalArgumentException("Room already booked");
        }

        Booking booking = new Booking(rooms.get(roomId), date, timeSlot);
        bookings.put(booking.getBookingId(), booking);
        bookingNotifier.notifyObservers(booking, "Created");
        return booking;
    }

    public void cancelBooking(UUID bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking != null) {
            bookingNotifier.notifyObservers(booking, "Canceled");
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        return rooms.values().stream()
                .filter(room -> room.getAmenities().equals(requiredAmenities))
                .filter(room -> bookings.values().stream()
                        .noneMatch(booking -> booking.isLocked(room.getRoomId(), date, timeSlot))).toList();
    }
}
