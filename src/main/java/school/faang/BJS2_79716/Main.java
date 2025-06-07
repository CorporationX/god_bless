package school.faang.BJS2_79716;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        // Добавление наблюдателя
        system.getBookingNotifier().addObserver((booking, status) -> {
            System.out.println("📢 Notification: Booking " + booking + " was " + status);
        });

        system.getBookingNotifier().addObserver((booking, status) -> {
            System.out.println("📢 Second Notification: Booking " + booking + " was " + status);
        });

        // Создание комнат
        Room room1 = new Room(101, "конференц-зал", new HashSet<>(Arrays.asList("проектор", "видеоконференция")));
        Room room2 = new Room(102, "переговорная", new HashSet<>(Collections.singletonList("видеоконференция")));

        system.addRoom(room1);
        system.addRoom(room2);

        // Бронирование комнат
        Booking b1 = system.bookRoom(101, "2025-06-06", "10:00-12:00");
        Booking b2 = system.bookRoom(102, "2025-06-06", "10:00-12:00");

        // Попытка повторного бронирования на тот же слот — должно быть отклонено
        Booking b3 = system.bookRoom(101, "2025-06-06", "10:00-12:00");
        System.out.println("✅ b3 null (ожидание): " + (b3 == null));

        // Отмена бронирования
        system.cancelBooking(b1.getBookingId());

        // Поиск доступных комнат
        Set<String> requiredAmenities = new HashSet<>(Collections.singletonList("видеоконференция"));
        List<Room> availableRooms = system.findAvailableRooms("2025-06-06", "10:00-12:00", requiredAmenities);
        System.out.println("🟩 Доступные комнаты: " + availableRooms);

        // Список бронирований на дату
        List<Booking> bookingsForDate = system.findBookingsForDate("2025-06-06");
        System.out.println("📅 Бронирования на 2025-06-06: " + bookingsForDate);
    }
}
