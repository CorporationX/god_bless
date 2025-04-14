package school.faang.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class BookingSystem {
    private final Map<Integer, Booking> bookings;
    private final Map<Integer, Room> roomNumbers;
    private final BookingNotifier bookingNotifier;

    private int bookingId;

    public BookingSystem() {
        this.bookingNotifier = new BookingNotifier();
        this.bookings = new HashMap<>();
        this.roomNumbers = new HashMap<>();
    }

    public Room addRoom(Room room) {
        return roomNumbers.put(room.getRoomNumber(), room);
    }

    public boolean removeRoom(Room room) {
        Room removedRoom = roomNumbers.remove(room.getRoomNumber());
        return removedRoom != null;
    }

    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        Room room = Optional.ofNullable(roomNumbers.get(roomNumber))
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Room with number %d doesn't exist", roomNumber)));
        int id = generateBookingId();
        Booking booking = new Booking(id, room, date, timeSlot);
        if (isRoomAvailable(room, date, timeSlot, Set.of())) {
            bookings.put(id, booking);
            bookingNotifier.notifyObservers(booking, "Created");
        } else {
            throw new RuntimeException(String.format("Room %s is already booked for %s and %s timeslot",
                    room.getRoomNumber(), date, timeSlot));
        }
        return booking;
    }

    public Booking cancelBooking(int bookingId) {
        Booking booking = Optional.ofNullable(bookings.get(bookingId))
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Booking with id %d doesn't exist", bookingId)));
        bookings.remove(bookingId);
        bookingNotifier.notifyObservers(booking, "Canceled");
        return booking;
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : roomNumbers.values()) {
            if (isRoomAvailable(room, date, timeSlot, requiredAmenities)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        return bookings.values().stream()
                .filter(booking -> booking.getDate().equals(date))
                .toList();
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot, Set<String> requiredAmenities) {
        return bookings.values().stream()
                .noneMatch(booking -> booking.getDate().equals(date) && booking.getTimeSlot().equals(timeSlot)
                        && room.getAmenities().containsAll(requiredAmenities));
    }

    private int generateBookingId() {
        return bookingId++;
    }
}