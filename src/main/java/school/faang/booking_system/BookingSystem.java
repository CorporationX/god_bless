package school.faang.booking_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookingSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room newRoom) {
        if (!rooms.contains(newRoom)) {
            rooms.add(newRoom);
        } else {
            System.out.println("Room already exists");
        }
    }

    public void removeRoom(int roomNumber) {
        validateRoomNumber(roomNumber);
        rooms.remove(findRoomByRoomNumber(roomNumber));
    }

    public void cancelBooking(int bookingId) {
        bookings.removeIf(booking -> booking.getBookingId().equals(bookingId));
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        return rooms.stream()
                .filter(room -> room.getAmenities().containsAll(requiredAmenities))
                .filter(room -> bookings.stream()
                        .noneMatch(booking ->
                                booking.getRoom() == room
                                        && booking.getDate().equals(date)
                                        && booking.getTimeSlot().equals(timeSlot)
                        )
                )
                .toList();
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        boolean alreadyBooked = bookings.stream()
                .filter(booking
                        -> booking.getRoom().getRoomNumber().equals(roomNumber))
                .anyMatch(booking
                        -> booking.getDate().equals(date)
                        && booking.getTimeSlot().equals(timeSlot));

        if (!alreadyBooked) {
            bookings.add(new Booking(findRoomByRoomNumber(roomNumber), date, timeSlot));
        } else {
            System.out.println("Already booked");
        }
    }

    public Room findRoomByRoomNumber(int roomNumber) {
        validateRoomNumber(roomNumber);
        return rooms.stream().filter(room -> room.getRoomNumber().equals(roomNumber))
               .findFirst().orElse(null);
    }

    public void validateRoomNumber(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Значение не может быть null или 0");
        }
    }
}
