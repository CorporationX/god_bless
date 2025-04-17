package school.faang.booking_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BookingSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void addRoom(Room newRoom) {
        if (!rooms.contains(newRoom)) {
            rooms.add(newRoom);
        } else {
            System.out.println("Room already exists");
        }
    }

    public static void removeRoom(int roomNumber) {
        validateRoomNumber(roomNumber);
        rooms.remove(findRoomByRoomNumber(roomNumber));
    }

    public static void cancelBooking(int bookingId) {
        bookings.removeIf(booking -> Objects.equals(booking.getBookingId(), (bookingId)));
    }

    public static List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        return rooms.stream()
                .filter(room -> room.getAmenities().containsAll(requiredAmenities))
                .filter(room -> bookings.stream()
                        .noneMatch(booking ->
                                booking.getRoom() == room
                                        && Objects.equals(booking.getDate(), date)
                                        && Objects.equals(booking.getTimeSlot(), timeSlot)
                        )
                )
                .toList();
    }

    public static void bookRoom(int roomNumber, String date, String timeSlot) {
        boolean alreadyBooked = bookings.stream()
                .filter(booking
                        -> Objects.equals(booking.getRoom().getRoomNumber(), roomNumber))
                .anyMatch(booking
                        -> Objects.equals(booking.getDate(), date)
                        && Objects.equals(booking.getTimeSlot(), timeSlot));

        if (!alreadyBooked) {
            bookings.add(new Booking(findRoomByRoomNumber(roomNumber), date, timeSlot));
        } else {
            System.out.println("Already booked");
        }
    }

    public static Room findRoomByRoomNumber(int roomNumber) {
        validateRoomNumber(roomNumber);
        return rooms.stream().filter(room -> Objects.equals(room.getRoomNumber(), roomNumber))
               .findFirst().orElse(null);
    }

    public static void validateRoomNumber(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Значение не может быть null или 0");
        }
    }
}
