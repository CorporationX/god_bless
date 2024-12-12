package school.faang.bjs244725;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        bookingSystem.addObserver((booking, status) ->
                System.out.println("Notification: Booking " + booking + " is " + status)
        );

        Set<String> amenities1 = new HashSet<>(Arrays.asList("Projector", "Video Conference"));
        Room room1 = new Room(1, "Conference Room", amenities1);

        Set<String> amenities2 = new HashSet<>(Arrays.asList("Whiteboard", "Markers"));
        Room room2 = new Room(2, "Meeting Room", amenities2);

        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);

        bookingSystem.bookRoom(1, "2023-12-01", "10:00-11:00");

        bookingSystem.cancelBooking(1);

        Set<String> requiredAmenities = new HashSet<>(Arrays.asList("Projector", "Video Conference"));
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2023-12-01", "10:00-11:00", requiredAmenities);
        System.out.println("Available rooms: " + availableRooms);

        List<Booking> bookingsForDate = bookingSystem.findBookingsForDate("2023-12-01");
        System.out.println("Bookings for date: " + bookingsForDate);
    }
}