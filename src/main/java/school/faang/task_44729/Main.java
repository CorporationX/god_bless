package school.faang.task_44729;

import java.util.Set;

public class Main {
    private static final BookingNotifier notifier = new BookingNotifier();
    private static final BookingSystem bookingSystem = new BookingSystem(notifier);

    public static void main(String[] args) {
        initData();

        BookingObserver emailNotification = (booking, status) ->
                System.out.printf("Sending email notification for booking: %s with status: %s%n",
                        booking, status);

        BookingObserver smsNotification = (booking, status) ->
                System.out.printf("Sending SMS notification for booking: %s with status: %s%n",
                        booking, status);

        BookingObserver pushNotification = (booking, status) ->
                System.out.printf("Sending push notification for booking: %s with status: %s%n",
                        booking, status);

        notifier.addObserver(emailNotification);
        notifier.addObserver(smsNotification);
        notifier.addObserver(pushNotification);


        bookingSystem.bookRoom(101, "1111.11.11", "10");
        bookingSystem.bookRoom(202, "1111.22.22", "10");
        bookingSystem.bookRoom(303, "1111.22.22", "10");
        bookingSystem.bookRoom(404, "1111.11.11", "10");

        notifier.removeObserver(smsNotification);

        String date1 = "1111.11.11";
        System.out.printf("findBookingForDate - %s:%n", date1);
        bookingSystem.findBookingsForDate(date1).forEach(booking -> System.out.printf("\t- %s%n", booking));
        System.out.println();

        bookingSystem.cancelBooking(1);
        System.out.println();

        bookingSystem.removeRoom(202);
        System.out.println();


        String date2 = "2222.22.22";
        String timeSlot = "22";
        Set<String> requiredAmenities = Set.of("Wi-Fi");
        System.out.printf("%s %s %s%n", date2, timeSlot, requiredAmenities);
        System.out.printf("Available rooms%n");

        bookingSystem.findAvailableRooms(date2, timeSlot, requiredAmenities)
                .forEach(room -> System.out.printf("\t- %s%n", room));
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
