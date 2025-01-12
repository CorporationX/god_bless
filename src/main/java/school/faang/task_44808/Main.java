package school.faang.task_44808;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.booking.domain.model.BookingFactory;
import school.faang.task_44808.booking.domain.observer.BookingObserver;
import school.faang.task_44808.booking.domain.system.BookingSystem;
import school.faang.task_44808.booking.domain.validator.BookingValidator;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;
import school.faang.task_44808.room.domain.manager.RoomManager;
import school.faang.task_44808.room.domain.model.RoomFactory;
import school.faang.task_44808.room.domain.validator.RoomValidator;

import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("=== Welcome to Room Manager ===");
        RoomManager manager = new RoomManager();

        log.info("\n=== Adding Rooms to Room Manager ===");
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        manager.addRoom(roomFactory.createRoom(RoomType.DOUBLE, Set.of(RoomAmenity.TV, RoomAmenity.WIFI)));
        manager.addRoom(roomFactory.createRoom(RoomType.SINGLE, Set.of(RoomAmenity.KITCHEN, RoomAmenity.BATHROOM)));
        manager.addRoom(roomFactory.createRoom(RoomType.SUITE, Set.of(RoomAmenity.KITCHEN, RoomAmenity.SMOKING)));
        manager.addRoom(roomFactory.createRoom(RoomType.TRIPLE, Set.of(RoomAmenity.WIFI, RoomAmenity.WATER_COURT)));

        log.info("\n=== Print All Rooms ===");
        manager.printAllRooms();

        BookingValidator bookingValidator = new BookingValidator(date -> {
        });
        BookingFactory bookingFactory = new BookingFactory(bookingValidator, 1);
        BookingSystem bookingSystem = new BookingSystem(bookingFactory);

        bookingSystem.getRooms().addAll(manager.getAllRooms());

        BookingObserver observer = (booking, status) -> {
            log.info("BookingObserver - Booking ID {} has status {}",
                    booking.getId(),
                    status);
        };
        bookingSystem.getNotifier().addObserver(observer);

        log.info("\n=== Booking Room ===");
        boolean booking1 = bookingSystem.bookRoom(1, "2023-12-06", "10:00-11:00");
        boolean booking2 = bookingSystem.bookRoom(1, "2023-12-06", "11:00-12:00");
        boolean bookingFail = bookingSystem.bookRoom(1, "2023-12-06", "10:00-11:00");

        log.info("Booking 1 success: {}", booking1);
        log.info("Booking 2 success: {}", booking2);
        log.info("Booking conflict success: {}", bookingFail);

        log.info("\n=== Find Bookings for Date ===");
        var bookings = bookingSystem.findBookingsForDate("2023-12-06");
        log.info("Bookings on 2023-12-06: {}", bookings);

        log.info("\n=== Cancel Booking ===");
        if (!bookings.isEmpty()) {
            bookingSystem.cancelBooking(bookings.get(0).getId());
        }

        log.info("\n=== Find Bookings Again ===");
        bookings = bookingSystem.findBookingsForDate("2023-12-06");
        log.info("Bookings on 2023-12-06 after cancellation: {}", bookings);
    }
}
