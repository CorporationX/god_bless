package school.faang.bjs2_79723_booking_system;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        BookingNotifier.addObserver(new EmailNotificationObserver());
        BookingNotifier.addObserver(new WebhookNotificationObserver());

        log.info("Test adding and booking a basic room");
        Room roomBasicNr1 = new Room(1, Room.ROOM_TYPE_CONFERENCE, null);
        BookingSystem.addRoom(roomBasicNr1);
        BookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");

        log.info("Test adding and booking another room with TV");
        Room roomTvNr2 = new Room(2, Room.ROOM_TYPE_CONFERENCE, Set.of(RoomAmenity.AMENITY_TV));
        BookingSystem.addRoom(roomTvNr2);
        BookingSystem.bookRoom(roomTvNr2.getRoomNumber(), "2025-01-01", "12:00");

        log.info("Test adding duplicate room");
        BookingSystem.addRoom(roomBasicNr1);

        log.info("Test booking same room different day");
        BookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-02", "12:00");

        log.info("Test booking same room, same day, different time");
        BookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-02", "13:00");

        log.info("Test double booking same room");
        BookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");

        log.info("Test removing the room");
        BookingSystem.removeRoom(roomBasicNr1.getRoomNumber());

        log.info("Test removing same room again");
        BookingSystem.removeRoom(roomBasicNr1.getRoomNumber());

        log.info("Add basic room 1 back with no bookings");
        BookingSystem.addRoom(roomBasicNr1);

        log.info("Test getting rooms available on a free day, no required amenities");
        printRooms(BookingSystem.findAvailableRooms("2025-01-03", "12:00", null));

        log.info("Test getting rooms available on a free day, but with a TV");
        printRooms(
                BookingSystem.findAvailableRooms("2025-01-03", "12:00", Set.of(RoomAmenity.AMENITY_TV))
        );

        log.info("Test getting rooms available on a free day, but with a TV and Camera");
        printRooms(
                BookingSystem.findAvailableRooms(
                        "2025-01-03",
                        "12:00",
                        Set.of(RoomAmenity.AMENITY_TV, RoomAmenity.AMENITY_CAMERA)
                )
        );

        log.info("Test getting rooms available when one room has a booking");
        printRooms(BookingSystem.findAvailableRooms("2025-01-01", "12:00", null));
    }

    private static void printRooms(List<Room> rooms) {
        System.out.println("Printing " + rooms.size() + " number of rooms");
        rooms.forEach(System.out::println);
    }
}
