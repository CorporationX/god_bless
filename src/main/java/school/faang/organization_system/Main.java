package school.faang.organization_system;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        BookingNotifier bookingNotifier = new BookingNotifier();
        Set<String> baseAmenities = new HashSet<>(List.of("ТВ", "Вайфай", "Ванна"));
        Set<String> luxOneAmenities = new HashSet<>(List.of("ТВ+", "Спа", "Джакузи"));
        Set<String> luxTwoAmenities = new HashSet<>(List.of("ТВ+", "Минибар", "Джакузи"));
        Set<String> vipAmenities = new HashSet<>(List.of("Кинозал", "Спа", "Бассейн"));
        bookingSystem.addRoom(new Room("Обычный номер", baseAmenities));
        bookingSystem.addRoom(new Room("Обычный номер", baseAmenities));
        bookingSystem.addRoom(new Room("Обычный номер", baseAmenities));
        bookingSystem.addRoom(new Room("Обычный номер", baseAmenities));
        bookingSystem.addRoom(new Room("Люкс", luxOneAmenities));
        bookingSystem.addRoom(new Room("Люкс", luxTwoAmenities));
        bookingSystem.addRoom(new Room("VIP", vipAmenities));
        bookingSystem.removeRoom(2);
        bookingSystem.bookRoom(3, "20-01-2025", "13:00 - 20:00");
        bookingSystem.findAvailableRooms("20-01-2025", "13:00 - 20:00", baseAmenities);
        System.out.println(bookingSystem.findAvailableRooms("20-01-2025", "13:00 - 20:00", baseAmenities)
        );


    }
}
