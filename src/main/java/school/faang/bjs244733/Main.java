package school.faang.bjs244733;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        BookingNotifier bookingNotifier = new BookingNotifier();
        bookingNotifier.addObserver(new Administrator());
        bookingNotifier.addObserver(new User());

        BookingSystem bookingSystem = getBookingSystem(bookingNotifier);

        bookingSystem.bookRoom(111, "25.12.2024", "2");
        bookingSystem.bookRoom(112, "31.12.2024", "9");
        bookingSystem.bookRoom(113, "31.12.2024", "9");


        System.out.println("-попытка бронирования ранее забронированной комнаты-");
        bookingSystem.bookRoom(112, "31.12.2024", "9");

        System.out.println("-список всех бронирований на указанную дату-");
        System.out.println(bookingSystem.findBookingsForDate("31.12.2024"));

        System.out.println();
        System.out.println("-отмена бронирования ранее забронированной комнаты-");

        bookingSystem.cancelBooking(2);

        System.out.println();
        System.out.println("-список всех бронирований на указанную дату после отмены бронирования-");
        System.out.println(bookingSystem.findBookingsForDate("31.12.2024"));
    }

    private static BookingSystem getBookingSystem(BookingNotifier bookingNotifier) {
        Set<String> amenitiesConference = new HashSet<>();
        amenitiesConference.add("projector");
        amenitiesConference.add("video conference");

        Set<String> amenitiesRest = new HashSet<>();
        amenitiesRest.add("refrigerator");
        amenitiesRest.add("swimming pool");
        amenitiesRest.add("hookah bar");

        BookingSystem bookingSystem = new BookingSystem(bookingNotifier);

        Room roomConference = new Room(111, RoomType.CONFERENCE_ROOM, amenitiesConference);
        bookingSystem.addRoom(roomConference);

        Room roomRestFloorGround = new Room(112, RoomType.APARTMENT, amenitiesRest);
        bookingSystem.addRoom(roomRestFloorGround);

        Room roomRestFloorSecond = new Room(113, RoomType.APARTMENT, amenitiesRest);
        bookingSystem.addRoom(roomRestFloorSecond);
        return bookingSystem;
    }
}
