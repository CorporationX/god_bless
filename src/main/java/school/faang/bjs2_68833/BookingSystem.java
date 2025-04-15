package school.faang.bjs2_68833;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import static school.faang.bjs2_68833.BookingIdCounter.getNextBookingId;
import static school.faang.bjs2_68833.BookingStatus.CREATED;
import static school.faang.bjs2_68833.BookingStatus.DELETED;

public class BookingSystem {
    private final Set<Room> rooms = new HashSet<>();
    private final Set<Booking> bookings = new HashSet<>();
    private final BookingNotifier bookingNotifier = new BookingNotifier();

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentInBookingSystemException("param in booking system is null");
        }
        if (rooms.contains(room)) {
            throw new RoomAlreadyExistsException("Room with number " + room.roomNumber() + " already exists");
        }
        rooms.add(room);
    }

    public void removeRoom(int roomNumber) {
        if (!rooms.removeIf(room -> Objects.equals(room.roomNumber(), roomNumber))) {
            throw new RoomNotFoundException("Room with number " + roomNumber + " not found");
        }
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        if (date == null || timeSlot == null) {
            throw new IllegalArgumentInBookingSystemException("param in booking system is null");
        }
        Room currentRoom = findRoomByNumber(roomNumber);
        if (!isRoomAvailable(currentRoom, date, timeSlot)) {
            throw new RoomAlreadyBookedException("Room with number " + roomNumber + " already booked");
        }
        Booking newBooking = new Booking(getNextBookingId(), currentRoom, date, timeSlot);
        bookings.add(newBooking);
        bookingNotifier.notifyObserver(newBooking, CREATED);
    }

    public void cancelBooking(int bookingId) {
        Booking booking = findBookingById(bookingId);
        bookings.remove(booking);
        bookingNotifier.notifyObserver(booking, DELETED);
    }

    public Set<Room> findAvailableRooms(String date, String timeSlot, Set<String> amenities) {
        if (date == null || timeSlot == null || amenities == null) {
            throw new IllegalArgumentInBookingSystemException("param in booking system is null");
        }
        Set<Room> availableRooms = new HashSet<>();
        for (Room room : rooms) {
            if (isRoomAvailable(room, date, timeSlot) && room.amenities().containsAll(amenities)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Set<Booking> findBookingsForDate(String date) {
        Set<Booking> bookingsForDate = new HashSet<>();
        for (Booking booking : bookings) {
            if (booking.date().equals(date)) {
                bookingsForDate.add(booking);
            }
        }
        return bookingsForDate;
    }

    private Room findRoomByNumber(int roomNumber) {
        return rooms.stream()
                .filter(room -> Objects.equals(room.roomNumber(), roomNumber))
                .findFirst()
                .orElseThrow(() -> new RoomNotFoundException("Room with number " + roomNumber + " not found"));
    }

    private Booking findBookingById(int bookingId) {
        return bookings.stream()
                .filter(booking -> Objects.equals(booking.bookingId(), bookingId))
                .findFirst()
                .orElseThrow(() -> new BookingNotFoundException("Booking with id " + bookingId + " not found"));
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot) {
        for (Booking booking : bookings) {
            if (booking.room().equals(room) && booking.date().equals(date) && booking.timeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }
}
