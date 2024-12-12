package school.faang.bjs244725;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Getter
public class BookingSystem {
    private static final Logger logger = LoggerFactory.getLogger(BookingSystem.class);

    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();
    private final BookingNotifier notifier = new BookingNotifier();

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null.");
        }
        rooms.put(room.getRoomId(), room);
        logger.info("Room added: {}", room);
    }

    public void removeRoom(int roomId) {
        if (rooms.remove(roomId) != null) {
            logger.info("Room removed with ID: {}", roomId);
        } else {
            logger.warn("Room with ID {} not found.", roomId);
        }
    }

    public void bookRoom(int roomId, String date, String timeSlot) {
        if (date == null || date.trim().isEmpty() || timeSlot == null || timeSlot.trim().isEmpty()) {
            throw new IllegalArgumentException("Date and timeSlot cannot be null or empty.");
        }
        Room room = rooms.get(roomId);
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }
        Booking booking = new Booking(bookings.size() + 1, room, date, timeSlot);
        bookings.put(booking.getBookingId(), booking);
        notifier.notifyObservers(booking, "Booked");
        logger.info("Room booked: {}", booking);
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking != null) {
            notifier.notifyObservers(booking, "Cancelled");
            logger.info("Booking cancelled: {}", booking);
        } else {
            throw new IllegalArgumentException("Booking not found");
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        if (date == null || date.trim().isEmpty() || timeSlot == null
                || timeSlot.trim().isEmpty() || requiredAmenities == null) {
            logger.error("Invalid input parameters: date={}, timeSlot={}, requiredAmenities={}",
                    date, timeSlot, requiredAmenities);
            return Collections.emptyList();
        }

        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            boolean isAvailable = bookings.values().stream()
                    .noneMatch(booking -> booking.getRoom().getRoomId() == room.getRoomId()
                            && booking.getDate().equals(date)
                            && booking.getTimeSlot().equals(timeSlot));
            if (isAvailable && room.getAmenities().containsAll(requiredAmenities)) {
                availableRooms.add(room);
            }
        }
        logger.info("Available rooms found: {}", availableRooms);
        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty.");
        }
        List<Booking> bookingsForDate = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getDate().equals(date)) {
                bookingsForDate.add(booking);
            }
        }
        logger.info("Bookings found for date {}: {}", date, bookingsForDate);
        return bookingsForDate;
    }

    public void addObserver(BookingObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null.");
        }
        notifier.addObserver(observer);
    }

    public void removeObserver(BookingObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null.");
        }
        notifier.removeObserver(observer);
    }
}