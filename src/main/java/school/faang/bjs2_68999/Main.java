package school.faang.bjs2_68999;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final BookingSystem BOOKING_SYSTEM = new BookingSystem();

    public static void main(String[] args) {
        BookingObserver adminObserver = new AdminObserver();
        BookingObserver userObserver = new UserObserver();
        BookingObserver guestObserver = new UserObserver();

        BookingNotifier.addObserver(adminObserver);
        BookingNotifier.addObserver(userObserver);
        BookingNotifier.addObserver(guestObserver);
        BookingNotifier.getObservers().forEach(bookingObserver -> log.info(bookingObserver.getClass().toString()));
        BookingNotifier.removeObserver(guestObserver);
        BookingNotifier.getObservers().forEach(bookingObserver -> log.info(bookingObserver.getClass().toString()));


        Room royalSuitRoom = new Room(
            "Пентхаус", 
            Set.of("проектор", "аудио система", "бассейн", "террасса", "холодильник"));
        Room budgetRoom = new Room("Бюджет", Set.of("холодильник", "кровать"));
        Room standardRoom = new Room("Стандарт", Set.of("холодильник", "телевизор", "кровать"));
        Room doubleRoom = new Room("Двойной", Set.of("холодильник", "телевизор", "кровать", "софа"));

        BOOKING_SYSTEM.addRoom(royalSuitRoom);
        BOOKING_SYSTEM.addRoom(budgetRoom);
        BOOKING_SYSTEM.addRoom(standardRoom);
        BOOKING_SYSTEM.removeRoom(standardRoom.getRoomNumber());
        BOOKING_SYSTEM.addRoom(doubleRoom);
        BOOKING_SYSTEM.getRooms().forEach((key, value) -> log.info("Room {} - {}.", key, value));

        BOOKING_SYSTEM.bookRoom(royalSuitRoom.getRoomNumber(), "2025-01-12", 3);
        BOOKING_SYSTEM.bookRoom(standardRoom.getRoomNumber(), "2025-02-01", 5);
        BOOKING_SYSTEM.bookRoom(budgetRoom.getRoomNumber(), "2025-03-31", 14);
        BOOKING_SYSTEM.bookRoom(royalSuitRoom.getRoomNumber(), "2025-01-20", 5);
        BOOKING_SYSTEM.bookRoom(royalSuitRoom.getRoomNumber(), "2025-01-19", 5);
        BOOKING_SYSTEM.bookRoom(budgetRoom.getRoomNumber(), "2025-01-01", 14);
        BOOKING_SYSTEM.bookRoom(royalSuitRoom.getRoomNumber(), "2025-01-01", 3);
        BOOKING_SYSTEM.getBookings().forEach((key, value) -> log.info("Booking {} - {}.", key, value));
        BOOKING_SYSTEM.cancelBooking(3);
        BOOKING_SYSTEM.cancelBooking(2);
        BOOKING_SYSTEM.getBookings().forEach((key, value) -> log.info("Booking {} - {}.", key, value));

        BOOKING_SYSTEM.findAvailableRooms("2025-01-01", 3, Set.of("холодильник"))
            .forEach(room -> log.info("{} доступна.", room.getType()));
        BOOKING_SYSTEM.findBookingsForDate("2025-01-01")
            .forEach(booking -> log.info("Резервация {} активна на дату.", booking.getBookingId()));

        BOOKING_SYSTEM.isBooked(1, "2025-01-01", 1);
    }
}
