package school.faang.booking_system;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        Room room101 = new Room(101, "Standard", Set.of("WiFi", "TV"));
        bookingSystem.addRoom(room101);

        bookingSystem.bookRoom(101, "2025-04-14", "10:00-11:00");

        bookingSystem.bookRoom(101, "2025-04-14", "10:00-11:00");

        Set<String> requiredAmenities = new HashSet<>(Set.of("WiFi"));
        List<Room> freeRooms = bookingSystem.findAvailableRooms("2025-04-14", "10:00-11:00", requiredAmenities);
        System.out.println("Свободные комнаты на слот: " + freeRooms.size());

        bookingSystem.cancelBooking(1);

        bookingSystem.removeRoom(101);
    }
}
