package school.faang.service;

import school.faang.model.Booking;
import school.faang.model.Room;
import school.faang.observer.BookingNotifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class BookingSystem {
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final List<Booking> bookings = new ArrayList<>();
    private final BookingNotifier notifier = new BookingNotifier();
    private int bookingIdCounter = 1;

    public void addRoom(Room room) {
        if (rooms.containsKey(room.getRoomNumber())) {
            throw new IllegalArgumentException("Room with this number already exists.");
        }
        rooms.put(room.getRoomNumber(), room);
    }

    public void removeRoom(int roomNumber) {
        boolean hasBookings = bookings.stream()
                .anyMatch(booking -> booking.getRoom().getRoomNumber() == roomNumber);

        if (hasBookings) {
            throw new IllegalStateException("Cannot remove room " + roomNumber + " as it has active bookings.");
        }
        rooms.remove(roomNumber);
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot) {
        return bookings.stream().noneMatch(booking ->
                booking.getRoom().equals(room)
                        && booking.getDate().equals(date)
                        && booking.getTimeSlot().equals(timeSlot));
    }

    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        Room room = rooms.get(roomNumber);
        if (room == null || !isRoomAvailable(room, date, timeSlot)) {
            throw new IllegalArgumentException(
                    room == null ? "Room with number " + roomNumber + " does not exist."
                            : "Room not available for the given time and date."
            );
        }
        Booking booking = new Booking(bookingIdCounter++, room, date, timeSlot);
        bookings.add(booking);
        notifier.notifyObservers(booking, "Booked");
        return booking;
    }

    public void cancelBooking(int bookingId) {
        bookings.removeIf(booking -> {
            if (booking.getBookingId() == bookingId) {
                notifier.notifyObservers(booking, "Cancelled");
                return true;
            }
            return false;
        });
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        return rooms.values().stream()
                .filter(room -> room.getAmenities().containsAll(requiredAmenities)
                        && isRoomAvailable(room, date, timeSlot)).toList();
    }

    public List<Booking> findBookingsForDate(String date) {
        return bookings.stream()
                .filter(booking -> booking.getDate().equals(date))
                .toList();
    }

    public BookingNotifier getNotifier() {
        return notifier;
    }
}
