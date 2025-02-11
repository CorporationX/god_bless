package school.faang.bookingsystem;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Slf4j
public class Main {
    private static final Set<String> CONFERENCE_AMENITIES = Set.of("projector", "screen", "microphone");
    private static final Set<String> MEETING_AMENITIES = Set.of("table", "chair", "video conference");
    private static final Set<String> GAMING_AMENITIES = Set.of("TV", "games");
    private static final Set<String> LECTURE_AMENITIES = Set.of("projector", "screen", "scene");
    private static final Set<String> OFFICE_AMENITIES = Set.of("table", "chair", "computer");
    private static final Set<String> SCREEN_AMENITY = Set.of("screen");
    private static final Set<String> TABLE_AMENITY = Set.of("table");
    private static final String FIFTEENTH_FEBRUARY =
            LocalDate.of(2020, 2, 15).toString();
    private static final String SIXTEENTH_FEBRUARY =
            LocalDate.of(2020, 2, 16).toString();
    private static final String NINETEENTH_FEBRUARY =
            LocalDate.of(2020, 2, 19).toString();
    private static final LocalTime NINE_AM_TIME = LocalTime.of(9, 0);
    private static final LocalTime TEN_AM_TIME = LocalTime.of(10, 30);
    private static final LocalTime ELEVEN_AM_TIME = LocalTime.of(11, 0);
    private static final LocalTime TWELVE_AM_TIME = LocalTime.of(12, 0);
    private static final LocalTime ONE_PM_TIME = LocalTime.of(13, 30);
    private static final String FIRST_INTERVAL = NINE_AM_TIME.toString() + "-" + TEN_AM_TIME.toString();
    private static final String SECOND_INTERVAL = NINE_AM_TIME + "-" + ELEVEN_AM_TIME.toString();
    private static final String THIRD_INTERVAL = ELEVEN_AM_TIME + "-" + TWELVE_AM_TIME.toString();
    private static final String FOURTH_INTERVAL = TEN_AM_TIME + "-" + ONE_PM_TIME.toString();

    public static void main(String[] args) {
        try {
            BookingSystem bookingSystem = getBooking();

            bookingSystem.findBookingsForDate(FIFTEENTH_FEBRUARY);
            bookingSystem.findBookingsForDate(SIXTEENTH_FEBRUARY);
            bookingSystem.findBookingsForDate(NINETEENTH_FEBRUARY);

            getAvailableRoomsNegativeTest(bookingSystem);
            getAvailableRoomsPositiveTests(bookingSystem);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }

    private static BookingSystem getBookingNotifier() {
        BookingNotifier notifier = new BookingNotifier();
        BookingObserver userObserver = (booking, status) ->
                log.info("USER: The booking status {} has been updated to {}", booking.getBookingId(), status);
        BookingObserver adminObserver = (booking, status) ->
                log.info("ADMIN: You have changed the booking status {} to {}", booking.getBookingId(), status);

        notifier.addObserver(userObserver);
        notifier.addObserver(adminObserver);
        notifier.addObserver(adminObserver);
        notifier.removeObserver(userObserver);
        notifier.removeObserver(userObserver);
        notifier.addObserver(userObserver);

        return new BookingSystem(notifier);
    }

    private static BookingSystem getBookingSystem() {
        BookingSystem bookingSystem = getBookingNotifier();

        Room conferenceRoom = new Room(101, "Conference", CONFERENCE_AMENITIES);
        Room meetingRoom = new Room(102, "Meeting", MEETING_AMENITIES);
        Room gamingRoom = new Room(201, "Gaming", GAMING_AMENITIES);
        Room lectureRoom = new Room(202, "Lecture", LECTURE_AMENITIES);
        Room officeRoom = new Room(203, "Office", OFFICE_AMENITIES);

        bookingSystem.addRoom(conferenceRoom);
        bookingSystem.addRoom(meetingRoom);
        bookingSystem.addRoom(gamingRoom);
        bookingSystem.addRoom(lectureRoom);
        bookingSystem.addRoom(officeRoom);
        bookingSystem.removeRoom(202);
        bookingSystem.removeRoom(202);
        bookingSystem.addRoom(lectureRoom);

        return bookingSystem;
    }

    private static BookingSystem getBooking() {
        BookingSystem bookingSystem = getBookingSystem();

        bookingSystem.bookRoom(101, FIFTEENTH_FEBRUARY, FIRST_INTERVAL);
        bookingSystem.bookRoom(101, FIFTEENTH_FEBRUARY, FIRST_INTERVAL);
        bookingSystem.bookRoom(101, FIFTEENTH_FEBRUARY, SECOND_INTERVAL);
        bookingSystem.bookRoom(101, FIFTEENTH_FEBRUARY, THIRD_INTERVAL);
        bookingSystem.bookRoom(101, FIFTEENTH_FEBRUARY, FOURTH_INTERVAL);
        bookingSystem.bookRoom(102, FIFTEENTH_FEBRUARY, SECOND_INTERVAL);
        bookingSystem.bookRoom(102, SIXTEENTH_FEBRUARY, SECOND_INTERVAL);
        bookingSystem.bookRoom(102, NINETEENTH_FEBRUARY, SECOND_INTERVAL);
        bookingSystem.bookRoom(201, FIFTEENTH_FEBRUARY, SECOND_INTERVAL);
        bookingSystem.bookRoom(202, FIFTEENTH_FEBRUARY, SECOND_INTERVAL);
        bookingSystem.bookRoom(203, FIFTEENTH_FEBRUARY, THIRD_INTERVAL);
        bookingSystem.bookRoom(202, NINETEENTH_FEBRUARY, THIRD_INTERVAL);
        bookingSystem.cancelBooking(1008);
        bookingSystem.cancelBooking(1008);
        bookingSystem.bookRoom(202, NINETEENTH_FEBRUARY, THIRD_INTERVAL);

        return bookingSystem;
    }

    private static void getAvailableRoomsNegativeTest(BookingSystem bookingSystem) {
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, FOURTH_INTERVAL, CONFERENCE_AMENITIES);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, FOURTH_INTERVAL, MEETING_AMENITIES);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, FOURTH_INTERVAL, GAMING_AMENITIES);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, FOURTH_INTERVAL, LECTURE_AMENITIES);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, FOURTH_INTERVAL, OFFICE_AMENITIES);
    }

    private static void getAvailableRoomsPositiveTests(BookingSystem bookingSystem) {
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, FIRST_INTERVAL, SCREEN_AMENITY);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, SECOND_INTERVAL, SCREEN_AMENITY);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, THIRD_INTERVAL, SCREEN_AMENITY);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, FIRST_INTERVAL, TABLE_AMENITY);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, SECOND_INTERVAL, TABLE_AMENITY);
        bookingSystem.findAvailableRooms(FIFTEENTH_FEBRUARY, THIRD_INTERVAL, TABLE_AMENITY);
        bookingSystem.findAvailableRooms(SIXTEENTH_FEBRUARY, FOURTH_INTERVAL, TABLE_AMENITY);
        bookingSystem.findAvailableRooms(SIXTEENTH_FEBRUARY, FOURTH_INTERVAL, SCREEN_AMENITY);
    }
}
