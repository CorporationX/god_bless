package school.faang.task_44729;

import java.util.Set;

public class Main {
    private static final BookingSystem bookingSystem = new BookingSystem();

    public static void main(String[] args) {
        initData();

        bookingSystem.bookRoom(101, "1111.11.11", "10");
        bookingSystem.bookRoom(202, "1111.22.22", "10");
        bookingSystem.bookRoom(303, "1111.22.22", "10");
        bookingSystem.bookRoom(404, "1111.11.11", "10");


        bookingSystem.findBookingsForDate("1111.11.11");
        System.out.println();

        bookingSystem.cancelBooking(1);
        System.out.println();

        bookingSystem.removeRoom(202);
        System.out.println();

        bookingSystem.findAvailableRooms("2222.22.22", "22", Set.of("Wi-Fi"));
        System.out.println();
    }

    private static void initData() {
        bookingSystem.addRoom(new Room(101, "Single",
                Set.of("Wi-Fi", "TV", "Air Conditioning")));
        bookingSystem.addRoom(new Room(202, "Suite",
                Set.of("Wi-Fi", "TV", "Air Conditioning", "Mini-bar", "Balcony")));
        bookingSystem.addRoom(new Room(303, "Economy",
                Set.of("Wi-Fi")));
        bookingSystem.addRoom(new Room(404, "Family",
                Set.of("Wi-Fi", "TV", "Air Conditioning", "Mini-kitchen", "Crib")));
        bookingSystem.addRoom(new Room(505, "Accessible",
                Set.of("Wi-Fi", "TV", "Air Conditioning", "Wide doors", "Disability accessories")));
    }

}
