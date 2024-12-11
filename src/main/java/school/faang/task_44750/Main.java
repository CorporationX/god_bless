package school.faang.task_44750;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        BookingSystem admin = new BookingSystem();
        AdminNotifier adminNotifier = new AdminNotifier();
        admin.getNotifier().addObserver(adminNotifier);

        admin.addRoom(new Room(1, "Конференц зал", Set.of("Проектор", "Доска ")));
        admin.addRoom(new Room(2, "Переговорная", Set.of("Видеоконференция")));
        admin.addRoom(new Room(3, "Фотостудия", Set.of("Kамера", "Прожектор")));
        admin.addRoom(new Room(3, "Фотостудия", Set.of("Kамера", "Прожектор")));

        System.out.println("Доступные комнаты: \n" + admin.findAvailableRooms("2012-12-12", "10:00-12:00", Set.of("Фотостудия")));

        admin.bookRoom(1, "2012-12-12", "10:00-12:00");
        admin.bookRoom(2, "2012-12-12", "10:00-12:00");
        admin.bookRoom(3, "2012-12-12", "10:00-12:00");

        System.out.println("Доступные комнаты: \n" + admin.findAvailableRooms("2012-12-12", "10:00-12:00", Set.of("Прожектор")));

        admin.cancelBooking(1);

        System.out.println("Доступные комнаты: \n" + admin.findAvailableRooms("2012-12-12", "10:00-12:00", Set.of("Проектор")));

        System.out.println("Забронированные 2012-12-12: \n" + admin.findBookingsForDate("2012-12-12"));
    }
}
