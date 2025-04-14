package school.faang.bookingmanagement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Booking System Test Start 😊 =====\n");




        Room room1 = new Room(101);
        room1.setType("Conference Room");
        room1.setAmenities(new HashSet<>(Arrays.asList("Projector", "Video Conferencing")));

        Room room2 = new Room(102);
        room2.setType("Meeting Room");
        room2.setAmenities(new HashSet<>(Arrays.asList("Whiteboard", "Conference Phone")));

        // Создаем экземпляр системы бронирования с новым экземпляром BookingNotifier
        BookingSystem bookingSystem = new BookingSystem();
        System.out.println("BookingSystem initialized ✅\n");
        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);
        System.out.println("Rooms added ✅");
        bookingSystem.removeRoom(room2);
        System.out.println("Room2 removed ✅");
        bookingSystem.addRoom(room2);
        System.out.println("Room2 added back ✅");

        System.out.println("Rooms added:");
        System.out.printf("Room %d: Type: %s, Amenities: %s\n", room1.getRoomNumber(), room1.getType(),
                room1.getAmenities());
        System.out.printf("Room %d: Type: %s, Amenities: %s\n", room2.getRoomNumber(), room2.getType(),
                room2.getAmenities());
        System.out.println();

        // Проверяем уникальность номеров комнат
        if (room1.getRoomNumber() != room2.getRoomNumber()) {
            System.out.println("✅ Unique room numbers verified.");
        } else {
            System.out.println("Error: Room numbers are not unique!");
        }
        System.out.println();

        // Обновляем данные для room1
        room1.setType("Updated Conference Room");
        room1.getAmenities().add("Coffee Machine");
        System.out.println("Updated Room 101 details:");
        System.out.printf("Room %d: Type: %s, Amenities: %s\n", room1.getRoomNumber(), room1.getType(),
                room1.getAmenities());
        System.out.println();

        // Регистрируем наблюдателей (Observer)
        AdminBookingObserver adminObserver = new AdminBookingObserver("Admin1");
        UserBookingObserver userObserver = new UserBookingObserver("User1");
        bookingSystem.getNotifier().addObserver(adminObserver);
        bookingSystem.getNotifier().addObserver(userObserver);
        System.out.println("Observers registered: Admin (Admin1) and User (User1) 👍\n");

        // Тест бронирования
        System.out.println("=== Booking Tests ===");
        System.out.println("Booking Room 101 on 2025-05-01 for time slot 10:00-12:00...");
        bookingSystem.bookRoom(101, "2025-05-01", "10:00-12:00");
        System.out.println();

        System.out.println("Booking Room 102 on 2025-05-01 for time slot 09:00-10:30...");
        bookingSystem.bookRoom(102, "2025-05-01", "09:00-10:30");
        System.out.println();

        // Тест поиска доступных комнат (например, требуемое удобство: "Projector")
        System.out.println("=== Find Available Rooms Test ===");
        Set<String> requiredAmenities = new HashSet<>(List.of("Projector"));
        System.out.println("Searching for available rooms on 2025-05-01 for time slot 12:00-13:00 with amenities: "
                + requiredAmenities);
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025-05-01", "12:00-13:00", requiredAmenities);
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms found");
        } else {
            System.out.println("Available rooms:");
            for (Room room : availableRooms) {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
        System.out.println();

        // Тест отмены бронирования
        System.out.println("=== Cancel Booking Test ===");
        // Предположим, что первое бронирование имеет ID равный 1
        System.out.println("Cancelling booking with ID 1...");
        bookingSystem.cancelBooking(1);
        System.out.println();

        // Тест поиска бронирований по дате
        System.out.println("=== Find Bookings For Date Test ===");
        System.out.println("Bookings for 2025-05-01:");
        List<Booking> bookingsForDate = bookingSystem.findBookingForDate("2025-05-01");
        if (bookingsForDate.isEmpty()) {
            System.out.println("No bookings found for 2025-05-01");
        } else {
            for (Booking b : bookingsForDate) {
                System.out.printf("Booking ID: %d, Room: %d, Date: %s, Time Slot: %s\n",
                        b.getBookingId(), b.getRoom().getRoomNumber(), b.getDate(), b.getTimeSlot());
            }
        }
        System.out.println("===== Booking System Test End  =====");
    }
}