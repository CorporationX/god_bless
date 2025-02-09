package school.faang.models;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.exceptions.BookingNotFoundException;
import school.faang.exceptions.BookingValidationError;
import school.faang.exceptions.RoomNotFoundException;
import school.faang.exceptions.RoomValidationException;
import school.faang.notifiers.BookingNotifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookingSystem {
    private static final Logger logger = LoggerFactory.getLogger(BookingSystem.class);

    private final Map<Integer, Room> roomMap;
    private final Map<Integer, Booking> bookingMap;
    private int bookingCnt = 1;
    @Getter
    private final BookingNotifier bookingNotifier = new BookingNotifier();

    public BookingSystem(Map<Integer, Room> roomMap, Map<Integer, Booking> bookingMap) {
        validateRooms(roomMap);
        validateBookings(bookingMap);
        this.roomMap = roomMap;
        this.bookingMap = bookingMap;
    }

    public boolean addRoom(Room room) {
        validateRoom(room);
        if (roomMap.containsKey(room.getRoomNumber())) {
            logger.info("Room with ID {} is already in system", room.getRoomNumber());
            return false;
        }
        roomMap.put(room.getRoomNumber(), room);
        logger.info("Room with ID {} was not added", room.getRoomNumber());
        return true;
    }

    public boolean removeRoom(Room room) {
        validateRoom(room);
        if (!roomMap.containsKey(room.getRoomNumber())) {
            logger.info("Room with ID {} was not found", room.getRoomNumber());
            throw new RoomNotFoundException(room.getRoomNumber());
        }
        roomMap.remove(room.getRoomNumber());
        logger.info("Room with ID {} was removed", room.getRoomNumber());
        return true;
    }

    public boolean bookRoom(int roomNumber, String date, String timeSlot) {
        if (!roomMap.containsKey(roomNumber)) {
            logger.info("Room with ID {} was not found", roomNumber);
            throw new RoomNotFoundException(roomNumber);
        }
        Room room = roomMap.get(roomNumber);
        for (Booking booking : bookingMap.values()) {
            if (booking.getRoom() == room && booking.getDate().equals(date)
                    && booking.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }
        Booking booking = new Booking(bookingCnt++, room, date, timeSlot);
        bookingMap.put(booking.getBookingId(), booking);
        bookingNotifier.notifyObservers(booking, "Created");
        logger.info("The room {} booked for {}, {}", room, date, timeSlot);
        return true;
    }

    public void cancelBooking(int bookingId) {
        if (!bookingMap.containsKey(bookingId)) {
            logger.info("Booking with ID {} was not found", bookingId);
            throw new BookingNotFoundException(bookingId);
        }
        Booking booking = bookingMap.remove(bookingId);
        bookingNotifier.notifyObservers(booking, "Cancelled");
        logger.info("The booking {} was cancelled", booking);
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : roomMap.values()) {
            if (room.getAmenities().containsAll(requiredAmenities) && isRoomAvailable(room, date, timeSlot)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot) {
        validateRoom(room);
        validateDate(date);
        validateTimeSlot(timeSlot);
        for (Booking booking : bookingMap.values()) {
            if (booking.getRoom().equals(room) && booking.getDate().equals(date)
                    && booking.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }

    private void validateRoom(Room room) {
        if (room == null) {
            throw new RoomValidationException("The room can't be null");
        }
    }

    private void validateDate(String date) {
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("The date can't be null or blank");
        }
    }

    private void validateTimeSlot(String timeSlot) {
        if (timeSlot == null || timeSlot.isBlank()) {
            throw new IllegalArgumentException("The timeSlot can't be null or blank");
        }
    }

    private void validateBooking(Booking booking) {
        if (booking == null) {
            throw new BookingValidationError("The booking can't be");
        }
    }

    private void validateRooms(Map<Integer, Room> rooms) {
        if (rooms == null) {
            throw new IllegalArgumentException("The rooms Map can't be null");
        }
        for (Room room : rooms.values()) {
            validateRoom(room);
        }
    }

    private void validateBookings(Map<Integer, Booking> bookingMap) {
        if (bookingMap == null) {
            throw new IllegalArgumentException("The bookingMap list can't be null");
        }
        for (Booking booking : bookingMap.values()) {
            validateBooking(booking);
        }
    }
}
