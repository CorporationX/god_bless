package school.faang.Module1.Booking_organization_system;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        //Пока закоментировал ибо мешало смотреть что в консоль выводится
        //bookingSystem.getNotifier().addObserver((booking, status) -> {
        //    System.out.println("Booking " + booking + "\nstatus: " + status);
        //});

        //Создаем комнаты
        bookingSystem.addRoom(new Room(101, "Single", new HashSet<>(Set.of("Wi-Fi", "TV"))));
        bookingSystem.addRoom(new Room(102, "Single", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar"))));
        bookingSystem.addRoom(new Room(103, "Single", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar"))));
        bookingSystem.addRoom(new Room(104, "Double", new HashSet<>(Set.of("Wi-Fi", "TV"))));
        bookingSystem.addRoom(new Room(105, "Double", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar"))));
        bookingSystem.addRoom(new Room(106, "Double", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar"))));
        bookingSystem.addRoom(new Room(107, "Suite", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar"))));
        bookingSystem.addRoom(new Room(108, "Suite", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar", "Kitchen"))));
        bookingSystem.addRoom(new Room(109, "Suite", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar", "Kitchen"))));
        bookingSystem.addRoom(new Room(110, "Suite", new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar", "Kitchen"))));

        //Проверка на повторное добавление такой же комнты номер 110
        bookingSystem.addRoom(new Room(110, "", new HashSet<>()));

        //Убираем комнату
        bookingSystem.removeRoom(new Room(102, "", new HashSet<>()));

        //Проверка на удаление не существующей комнаты
        bookingSystem.removeRoom(new Room(102, "", new HashSet<>()));

        // Бронируем несколько существующих возможных комнат
        bookingSystem.bookRoom(101, LocalDate.of(2025, 11, 10), LocalDate.of(2025, 11, 12));
        bookingSystem.bookRoom(103, LocalDate.of(2025, 11, 10), LocalDate.of(2025, 11, 12));
        bookingSystem.bookRoom(104, LocalDate.of(2025, 11, 10), LocalDate.of(2025, 11, 12));
        bookingSystem.bookRoom(105, LocalDate.of(2025, 11, 10), LocalDate.of(2025, 11, 12));
        bookingSystem.bookRoom(106, LocalDate.of(2025, 11, 10), LocalDate.of(2025, 11, 12));


        // ТЕСТЫ БРОНИРОВАНИЯ
        // Бронируем не существующую комнату
        bookingSystem.bookRoom(102, LocalDate.of(2025, 11, 10), LocalDate.of(2025, 11, 12));

        // Бронируем комнату которая уже забронирована ну ту же дату или перекрещивается с той же датой
        bookingSystem.bookRoom(105, LocalDate.of(2025, 11, 10), LocalDate.of(2025, 11, 12));

        //Убираем бронь комнаты с ID 1
        bookingSystem.cancelBooking(1);

        //Убираем бронь комнаты с уже несуществующим ID 1
        bookingSystem.cancelBooking(1);

        //Смотрим какие комнаты доступны
        bookingSystem.findAvailableRooms(LocalDate.of(2025, 11, 10),
                LocalDate.of(2025, 11, 12), new HashSet<>(Set.of("Wi-Fi", "TV", "Mini-bar", "Kitchen")));

        //Исщем бронирование на указанную дату
        bookingSystem.findBookingsForDate(LocalDate.of(2025, 11, 10));

        bookingSystem.findBookingsForDate(LocalDate.of(2025, 12, 10));
    }
}