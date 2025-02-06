package school.faang.service;

import school.faang.model.Booking;
import school.faang.model.Room;
import school.faang.observer.BookingNotifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookingSystem {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private final BookingNotifier notifier = new BookingNotifier();
    private int bookingIdCounter = 1;

    /**
     * Adds a room to the system.
     *
     * @param room The room to be added.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Removes a room from the system.
     *
     * @param roomNumber The unique number of the room to be removed.
     */
    public void removeRoom(int roomNumber) {
        rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
    }

    /**
     * Books a room for the specified date and time slot.
     *
     * @param roomNumber The room number.
     * @param date       The booking date (format: YYYY-MM-DD).
     * @param timeSlot   The time slot (e.g., 10:00-11:00).
     * @return The created booking.
     */
    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber &&
                    findAvailableRooms(date, timeSlot, room.getAmenities()).contains(room)) {

                Booking booking = new Booking(bookingIdCounter++, room, date, timeSlot);
                bookings.add(booking);
                notifier.notifyObservers(booking, "Booked");
                return booking;
            }
        }
        throw new IllegalArgumentException("Room not available for the given time and date.");
    }

    /**
     * Cancels a booking by its unique identifier.
     *
     * @param bookingId The booking ID.
     */
    public void cancelBooking(int bookingId) {
        bookings.removeIf(booking -> {
            if (booking.getBookingId() == bookingId) {
                notifier.notifyObservers(booking, "Cancelled");
                return true;
            }
            return false;
        });
    }

    /**
     * Finds all available rooms for the specified date, time slot, and amenities.
     *
     * @param date             The booking date.
     * @param timeSlot         The time slot.
     * @param requiredAmenities The set of required amenities.
     * @return A list of available rooms.
     */
    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            boolean isAvailable = bookings.stream().noneMatch(booking ->
                    booking.getRoom().equals(room) &&
                            booking.getDate().equals(date) &&
                            booking.getTimeSlot().equals(timeSlot));
            boolean hasAmenities = room.getAmenities().containsAll(requiredAmenities);

            if (isAvailable && hasAmenities) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /**
     * Finds all bookings for the specified date.
     *
     * @param date The booking date.
     * @return A list of bookings for the date.
     */
    public List<Booking> findBookingsForDate(String date) {
        List<Booking> bookingsForDate = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getDate().equals(date)) {
                bookingsForDate.add(booking);
            }
        }
        return bookingsForDate;
    }

    /**
     * Gets the notifier for booking updates.
     *
     * @return The booking notifier.
     */
    public BookingNotifier getNotifier() {
        return notifier;
    }
}
