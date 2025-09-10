package school.faang.Module1.Booking_organization_system;

import java.time.LocalDate;
import java.util.*;

public class BookingSystem {

    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();
    private final BookingNotifier bookingNotifier = new BookingNotifier();
    private int bookingNewId = 1;

    public void addRoom(Room room) {
        if (!rooms.containsKey(room.getRoomNumber())) {
            rooms.put(room.getRoomNumber(), room);
            System.out.printf("Room number %d has been added ✅\n", room.getRoomNumber());
        } else {
            System.out.printf("Room number %d already exist ❌\n", room.getRoomNumber());
        }
    }

    public void removeRoom(Room room) {

        if (rooms.containsKey(room.getRoomNumber())) {
            rooms.remove(room.getRoomNumber());
            System.out.printf("Room number %d has been removed ✅\n", room.getRoomNumber());
        } else {
            System.out.printf("Room number %d not found ❌\n", room.getRoomNumber());
        }
    }

    public void bookRoom(int roomNumber, LocalDate newCheckInDate, LocalDate newCheckOutDate) {
        Room room = rooms.get(roomNumber);

        if (room == null) {
            System.out.printf("Room %d does not exist ❌\n", roomNumber);
            return;
        }

        for (Booking b : bookings.values()) {
            if (b.getRoom().getRoomNumber() == room.getRoomNumber()
                    && b.bookingConflicts(newCheckInDate, newCheckOutDate)) {
                System.out.printf("Room %d is already booked at this period ❌\n", room.getRoomNumber());
                return;
            }
        }

        Booking booking = new Booking(bookingNewId++, room, newCheckInDate, newCheckOutDate);

        bookings.put(booking.getBookingId(), booking);

        bookingNotifier.notifyObservers(booking, " - Booking created ✅\n");

        System.out.printf("Room %d has successfully booked ✅\n", room.getRoomNumber());
    }

    public void cancelBooking(int bookingId) {

        if (bookings.containsKey(bookingId)) {
            Booking booking = bookings.remove(bookingId);
            bookingNotifier.notifyObservers(booking, " - Booking cancelled ✅\n");
            System.out.printf("Room number %d has been canceled ✅\n", booking.getRoom().getRoomNumber());
        } else {
            System.out.printf("Room number with ID %d does not exist ❌\n", bookingId);
        }
    }

    public void findAvailableRooms(LocalDate newCheckInDate, LocalDate newCheckOutDate, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>(rooms.values());

        availableRooms.removeIf(room -> bookings.values().stream()
                .anyMatch(booking -> booking.getRoom().getRoomNumber() == room.getRoomNumber() && booking
                        .bookingConflicts(newCheckInDate, newCheckOutDate)));

        availableRooms.removeIf(room -> !room.getRoomAmenities().containsAll(requiredAmenities));

        for (Room room : availableRooms) {
            System.out.printf("Room: %d, Amenities: %s, Date: %s - %s ✅\n",
                    room.getRoomNumber(),
                    room.getRoomAmenities(),
                    newCheckInDate,
                    newCheckOutDate);
        }
    }

    public void findBookingsForDate(LocalDate newCheckInDate) {
        List<Booking> bookingsForDate = new ArrayList<>();
        boolean found = false;

        for (Booking booking : bookings.values()) {

            if (booking.getCheckInDate().equals(newCheckInDate)) {
                bookingsForDate.add(booking);
                System.out.println(booking + "✅");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bookings with that day are exist ❌\n");
        }

    }

    public BookingNotifier getNotifier() {
        return bookingNotifier;
    }
}