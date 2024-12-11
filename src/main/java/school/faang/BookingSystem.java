package school.faang;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Getter
public class BookingSystem {
    private static final Logger logger = LoggerFactory.getLogger(BookingSystem.class);

    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private final BookingNotifier notifier = new BookingNotifier();

    public void addRoom(Room room) {
        rooms.add(room);
        logger.info("Room added: {}", room);
    }

    public void removeRoom(int roomId) {
        rooms.removeIf(room -> room.getRoomId() == roomId);
        logger.info("Room removed with ID: {}", roomId);
    }

    public void bookRoom(int roomId, String date, String timeSlot) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                Booking booking = new Booking(bookings.size() + 1, room, date, timeSlot);
                bookings.add(booking);
                notifier.notifyObservers(booking, "Booked");
                logger.info("Room booked: {}", booking);
                return;
            }
        }
        throw new IllegalArgumentException("Room not found");
    }

    public void cancelBooking(int bookingId) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getBookingId() == bookingId) {
                iterator.remove();
                notifier.notifyObservers(booking, "Cancelled");
                logger.info("Booking cancelled: {}", booking);
                return;
            }
        }
        throw new IllegalArgumentException("Booking not found");
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            boolean isAvailable = bookings.stream()
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
        List<Booking> bookingsForDate = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getDate().equals(date)) {
                bookingsForDate.add(booking);
            }
        }
        logger.info("Bookings found for date {}: {}", date, bookingsForDate);
        return bookingsForDate;
    }

    public void addObserver(BookingObserver observer) {
        notifier.addObserver(observer);
    }

    public void removeObserver(BookingObserver observer) {
        notifier.removeObserver(observer);
    }
}