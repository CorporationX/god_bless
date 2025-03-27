package school.faang.bookingsystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        // Создаем наблюдателя и добавляем его в систему
        AdminNotifier adminNotifier = new AdminNotifier();
        GuestNotifier guestNotifier = new GuestNotifier();
        bookingSystem.getNotifier().addObserver(adminNotifier);
        bookingSystem.getNotifier().addObserver(guestNotifier);

        // Добавляем комнаты
        Set<String> amenities1 = new HashSet<>(Arrays.asList("проектор", "видеоконференция"));
        Room room1 = new Room(101, "Переговорная", amenities1);
        bookingSystem.addRoom(room1);

        Set<String> amenities2 = new HashSet<>(Collections.singletonList("проектор"));
        Room room2 = new Room(102, "Конференц-зал", amenities2);
        bookingSystem.addRoom(room2);

        // Бронируем комнату
        bookingSystem.bookRoom(101, "2023-10-15", "10:00-12:00");

        // Ищем доступные комнаты
        Set<String> requiredAmenities = new HashSet<>(Arrays.asList("проектор", "видеоконференция"));
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2023-10-15", "10:00-12:00", requiredAmenities);
        System.out.println("Доступные комнаты: " + availableRooms.size());

        // Отменяем бронирование
        bookingSystem.cancelBooking(1);
    }
}
