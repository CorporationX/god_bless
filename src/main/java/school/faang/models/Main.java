package school.faang.models;

import school.faang.notifiers.AdminNotifier;
import school.faang.notifiers.BookingNotifier;
import school.faang.notifiers.GuestNotifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Room> rooms = new HashMap<>();
        rooms.put(1, new Room("room1", Set.of("Projector"), 1));
        rooms.put(2, new Room("room2", Set.of("Sofa"), 2));
        BookingSystem bookingSystem = new BookingSystem(rooms, new HashMap<>());
        bookingSystem.addRoom(new Room("room3", new HashSet<>(), 3));
        bookingSystem.removeRoom(new Room("room3", new HashSet<>(), 3));

        BookingNotifier bookingNotifier = new BookingNotifier();
        bookingSystem.getBookingNotifier().addObserver(new AdminNotifier());
        bookingSystem.getBookingNotifier().addObserver(new GuestNotifier());
        bookingNotifier.addObserver(new GuestNotifier());
        bookingSystem.bookRoom(1, "19-04-2025", "19:00");

        bookingSystem.cancelBooking(1);
        System.out.println(bookingSystem.findAvailableRooms("20-04-2025", "20:00", Set.of("Projector")));
    }
}
