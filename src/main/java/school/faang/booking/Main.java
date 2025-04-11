package school.faang.booking;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.addObserver(new User("Вася", "vasy@gmail.com"));

        Set<String> amenities = new HashSet<>(Arrays.asList("кровать", "тв"));
        Room room1 = new Room("эконом", amenities);
        bookingSystem.addRoom(room1);
        Room room2 = new Room("бизнес", amenities);
        bookingSystem.addRoom(room2);

        Booking booking1 = bookingSystem.bookRoom(1, "11-04-2025", "10:00-12:00");
        Booking booking2 = bookingSystem.bookRoom(2, "11-04-2025", "13:00-15:00");

        try {
            bookingSystem.bookRoom(1, "11-04-2025", "10:00-12:00");
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Set<String> requiredAmenities = new HashSet<>(Collections.singletonList("кровать"));
        List<Room> rooms = bookingSystem.findAvailableRooms("11-04-2025", "08:00-09:00", requiredAmenities);
        System.out.println("Доступные комнаты: " + rooms);

        bookingSystem.addObserver(new User("Лена", "lena@yandex.ru"));

        bookingSystem.cancelBooking(booking1.getBookingId());

        List<Booking> bookings = bookingSystem.findBookingsForDate("11-04-2025");
        System.out.println("Бронирования на 2023-12-01: " + bookings);

        bookingSystem.removeRoom(2);
    }
}
