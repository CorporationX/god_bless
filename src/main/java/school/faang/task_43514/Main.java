package school.faang.task_43514;

import school.faang.task_43514.enums.Amenities;
import school.faang.task_43514.enums.RoomType;
import school.faang.task_43514.model.Room;

import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = initBookingSystem();

        // Поиск свободных комнат
        var availableRooms = bookingSystem.findAvailableRooms(LocalDateTime.now(), Set.of(Amenities.WIFI));
        System.out.println("Свободные комнаты до бронирования:");
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        // Бронирование комнаты
        System.out.println("\nБронирование комнаты 1...");
        bookingSystem.bookRoom(1, LocalDateTime.now());

        // Проверка доступности после бронирования
        availableRooms = bookingSystem.findAvailableRooms(LocalDateTime.now(), Set.of(Amenities.WIFI));
        System.out.println("\nСвободные комнаты после бронирования:");
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        // Отмена бронирования
        System.out.println("\nОтмена бронирования для комнаты 1...");
        bookingSystem.cancelBooking(0);

        // Проверка доступности после отмены бронирования
        availableRooms = bookingSystem.findAvailableRooms(LocalDateTime.now(), Set.of(Amenities.WIFI));
        System.out.println("\nСвободные комнаты после отмены бронирования:");
        for (Room room : availableRooms) {
            System.out.println(room);
        }
    }

    private static BookingSystem initBookingSystem() {
        BookingNotifier notifier = new BookingNotifier();
        BookingSystem bookingSystem = new BookingSystem(notifier);

        // Добавление комнат
        Room room1 = new Room(1, RoomType.MEETING_ROOM, Set.of(Amenities.COFFEE_MACHINE, Amenities.WIFI), true);
        Room room2 = new Room(2, RoomType.CONFERENCE_HALL, Set.of(Amenities.WHITEBOARD, Amenities.WIFI), true);
        Room room3 = new Room(3, RoomType.MEETING_ROOM, Set.of(Amenities.PROJECTOR, Amenities.WIFI), true);

        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);
        bookingSystem.addRoom(room3);

        return bookingSystem;
    }
}
