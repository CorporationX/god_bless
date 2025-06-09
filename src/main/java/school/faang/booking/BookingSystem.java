package school.faang.booking;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import school.faang.booking.domain.Booking;
import school.faang.booking.domain.Room;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Slf4j
public class BookingSystem {

    private final BookingNotifier bookingNotifier = new BookingNotifier();
    private final Map<Integer, Room> roomsByNumber = new HashMap<>();
    private final Map<Integer, Booking> bookingsById = new HashMap<>();
    private final Map<String, Set<Booking>> bookingsByDate = new HashMap<>();

    private int lastBookingId = 0;

    public void addRoom(@NonNull Room room) {
        roomsByNumber.put(room.getNumber(), room);
        log.info("Added room {}", room.getNumber());
    }

    public void removeRoom(int roomNumber) {
        var removed = roomsByNumber.remove(roomNumber);
        if (removed != null) {
            log.info("Removed room {}", roomNumber);
        }
    }

    public void bookRoom(int roomNumber, @NonNull String date, @NonNull String timeSlot) {
        var room = roomsByNumber.get(roomNumber);
        if (room == null) {
            log.warn("Room {} not found", roomNumber);
            return;
        }
        var availableRooms = findAvailableRooms(date, timeSlot, room.getAmenities());
        if (!availableRooms.contains(room)) {
            log.warn("Room {} is not available", roomNumber);
            return;
        }
        var newBooking = createNewBooking(date, timeSlot, room);
        bookingNotifier.notifyObservers(newBooking, "Booked");
    }

    private Booking createNewBooking(@NonNull String date, @NonNull String timeSlot, @NonNull Room room) {
        var newBooking = new Booking(lastBookingId++, room, date, timeSlot);
        bookingsById.put(newBooking.getId(), newBooking);
        bookingsByDate.putIfAbsent(date, new HashSet<>());
        bookingsByDate.get(date).add(newBooking);
        log.info("Added new booking {}", newBooking);
        return newBooking;
    }

    public void cancelBooking(int bookingId) {
        var removedBooking = removeFromBookingsById(bookingId);
        if (removedBooking == null) {
            return;
        }
        var booking = removeFromBookingsByDate(removedBooking);
        if (booking == null) {
            return;
        }
        log.info("Cancelled booking {}", bookingId);
        bookingNotifier.notifyObservers(removedBooking, "Cancelled");
    }

    private Booking removeFromBookingsById(int bookingId) {
        var removedBooking = bookingsById.remove(bookingId);
        if (removedBooking == null) {
            log.warn("Booking {} not found", bookingId);
            return null;
        }
        return removedBooking;
    }

    private Booking removeFromBookingsByDate(Booking booking) {
        var bookingDate = booking.getDate();
        var bookings = bookingsByDate.get(bookingDate);
        if (bookings == null) {
            log.warn("Booking {} not found by dare {}", booking.getId(), bookingDate);
            return null;
        }
        bookings.remove(booking);
        if (bookings.isEmpty()) {
            bookingsByDate.remove(bookingDate);
        }
        return booking;
    }

    public Set<Room> findAvailableRooms(@NonNull String date, @NonNull String timeSlot, @NonNull Set<String> requiredAmenities) {
        return bookingsById.values().stream()
                .filter(booking -> !booking.getDate().equals(date) && !booking.getTimeSlot().equals(timeSlot))
                .map(Booking::getRoom)
                .filter(room -> room.getAmenities().containsAll(requiredAmenities))
                .collect(Collectors.toUnmodifiableSet());
    }

    public Set<Booking> findBookingsForDate(String date) {
        return bookingsByDate.get(date);
    }
}
