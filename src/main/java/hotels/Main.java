package hotels;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        BookingSystem bookingSystem = new BookingSystem();

        bookingSystem.addObserver(new AdminNotifier());

        // Создаём комнаты
        Set<String> amenities1 = new HashSet<>();
        amenities1.add("Проектор");
        amenities1.add("Кондиционер");

        Set<String> amenities2 = new HashSet<>();
        amenities2.add("Видеоконференция");
        amenities2.add("Доска для заметок");

        Room room1 = new Room(101, "Конференц-зал", amenities1);
        Room room2 = new Room(102, "Переговорная", amenities2);

        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);

        bookingSystem.bookRoom(101, "2025-04-15", "10:00-12:00");

        bookingSystem.bookRoom(102, "2025-04-15", "10:00-12:00");

        Set<String> requiredAmenities = new HashSet<>();
        requiredAmenities.add("Проектор");

        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025-04-15", "10:00-12:00", requiredAmenities);

        System.out.println("\nAvailable Rooms:");
        for (Room room : availableRooms) {
            System.out.println("Room Number: " + room.getRoomNumber() + ", Type: " + room.getType());
        }

        bookingSystem.cancelBooking(1);

        availableRooms = bookingSystem.findAvailableRooms("2025-04-15", "10:00-12:00", requiredAmenities);

        System.out.println("\nAvailable Rooms After Cancellation:");
        for (Room room : availableRooms) {
            System.out.println("Room Number: " + room.getRoomNumber() + ", Type: " + room.getType());
        }
    }
}
