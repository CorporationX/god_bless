package school.faang.bjs2_79738;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Getter
public class BookingSystem {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

    private final BookingNotifier notifier = new BookingNotifier();

    public void addRoom(Room room) {
        if (!rooms.contains(room)) {
            rooms.add(room);
            log.info("Room added: {}", room);
        } else {
            log.info("Room already exists: {}", room);
        }
    }

    public void removeRoom(int roomNumber) {
        Room roomToRemove = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                roomToRemove = room;
                break;
            }
        }

        if (roomToRemove != null) {
            rooms.remove(roomToRemove);
            log.info("Room removed: {}", roomToRemove);
        } else {
            log.info("Room not found: {}", roomNumber);
        }
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        Room foundRoom = null;

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                foundRoom = room;
                break;
            }
        }

        if (foundRoom == null) {
            log.info("Room not found: {}", roomNumber);
            return;
        }

        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber
                    && booking.getDate().equals(date)
                    && booking.getTimeSlot().equals(timeSlot)) {
                log.info("Room already booked for date {} and timeslot {}", date, timeSlot);
                return;
            }
        }

        int bookingId = bookings.size() + 1;
        Booking newBooking = new Booking(bookingId, foundRoom, date, timeSlot);
        bookings.add(newBooking);

        notifier.notifyObservers(newBooking, "BOOKED");

        log.info("Room {} successfully booked for {} at {}", roomNumber, date, timeSlot);
    }

    public void cancelBooking(int bookingId) {
        Booking foundBooking = null;

        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                foundBooking = booking;
                break;
            }
        }

        if (foundBooking == null) {
            log.info("Booking with ID {} not found.", bookingId);
            return;
        }

        bookings.remove(foundBooking);

        notifier.notifyObservers(foundBooking, "CANCELLED");

        log.info("Booking with ID {} cancelled successfully.", bookingId);
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            boolean isBooked = false;

            for (Booking booking : bookings) {
                if (booking.getRoom().equals(room)
                        && booking.getDate().equals(date)
                        && booking.getTimeSlot().equals(timeSlot)) {
                    isBooked = true;
                    break;
                }
            }

            if (!isBooked && room.getAmenities().containsAll(requiredAmenities)) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        List<Booking> result = new ArrayList<>();

        for (Booking booking : bookings) {
            if (booking.getDate().equals(date)) {
                result.add(booking);
            }
        }

        if (result.isEmpty()) {
            log.info("No bookings found for date: {}", date);
        } else {
            log.info("Found {} bookings for date: {}", result.size(), date);
            for (Booking booking : result) {
                log.info("Booking ID: {}, Room: {}, Time Slot: {}",
                        booking.getBookingId(), booking.getRoom().getRoomNumber(), booking.getTimeSlot());
            }
        }

        return result;
    }
}