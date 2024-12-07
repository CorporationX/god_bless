package school.faang.task_44736;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingNotifier notifier = new BookingNotifier();
        Administrator administrator1 = new Administrator("Alex");
        Administrator administrator2 = new Administrator("Ben");
        notifier.addObserver(administrator1);
        notifier.addObserver(administrator2);
        BookingSystem bookingSystem = new BookingSystem(notifier);
        bookingSystem.addRoom(new Room("conference", Set.of("TV")));
        bookingSystem.addRoom(new Room("conference-hall", Set.of("TV, chair")));
        bookingSystem.bookRoom(1, "07.12.2024", "14.00 - 15.00");
        notifier.removeObserver(administrator2);
        bookingSystem.bookRoom(2, "07.12.2024", "14.00 - 15.00");
        bookingSystem.cancelBooking(2);
    }
}
