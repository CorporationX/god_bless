package school.faang.bjs2_79738;

import java.util.Set;

public class DemoApp {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        bookingSystem.addRoom(new Room(101, "Conference Room"));
        bookingSystem.addRoom(new Room(102, "Meeting Room"));

        BookingObserver observer = new ConsoleBookingObserver();

        bookingSystem.getNotifier().addObserver(observer);

        bookingSystem.bookRoom(101, "2025-06-10", "09:00-10:00");
        bookingSystem.bookRoom(102, "2025-06-10", "09:00-10:00");

        bookingSystem.bookRoom(101, "2025-06-10", "09:00-10:00");

        bookingSystem.cancelBooking(1);

        var availableRooms = bookingSystem.findAvailableRooms("2025-06-10", "09:00-10:00", Set.of("WiFi"));
        System.out.println("Available rooms with WiFi at 09:00-10:00 on 2025-06-10:");
        for (Room room : availableRooms) {
            System.out.println("Room number: " + room.getRoomNumber());
        }

        bookingSystem.findBookingsForDate("2025-06-10");
    }
}
