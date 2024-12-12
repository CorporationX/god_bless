package school.faang.task_44732;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.addObserver(new BookingObserverImpl());

        system.addRoom(new Room(1, "Conference hall", Set.of("projector", "video conference")));
        system.addRoom(new Room(2, "negotiation room", Set.of("video conference")));

        system.bookRoom(1, "2024-06-01", "10:00-12:00");
        system.bookRoom(2, "2024-06-01", "10:00-12:00");

        //double booking
        system.bookRoom(2, "2024-06-01", "10:00-12:00");

        System.out.println("Available rooms: "
                + system.findAvailableRooms("2024-06-01", "10:00-12:00", Set.of("video conference")));

        system.cancelBooking(1);
        System.out.println("Available rooms: "
                + system.findAvailableRooms("2024-06-01", "10:00-12:00", Set.of("video conference")));
    }
}
