package school.faang.sprint_1.booking_system;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Room room101 = new Room(101, "Standard", Set.of("WiFi", "TV"));
        BookingSystem.addRoom(room101);

        BookingSystem.bookRoom(101, "2025-04-14", "10:00-11:00");

        BookingSystem.bookRoom(101, "2025-04-14", "10:00-11:00");

        Set<String> requiredAmenities = new HashSet<>(Set.of("WiFi"));
        List<Room> freeRooms = BookingSystem.findAvailableRooms("2025-04-14", "10:00-11:00", requiredAmenities);
        System.out.println("Свободные комнаты на слот: " + freeRooms.size());

        BookingSystem.cancelBooking(1);

        BookingSystem.removeRoom(101);
    }
}
