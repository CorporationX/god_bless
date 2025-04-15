package school.faang.stream1.bookingsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookingSystemTest {
    private static String date1;
    private static String date2;
    private static String timeSlot1;
    private static String timeSlot2;
    private static String timeSlot3;
    private BookingSystem bookingSystem;

    @BeforeAll
    public static void init() {
        date1 = "20250415";
        date1 = "20250416";
        timeSlot1 = "000000000000" //0-3
                + "000000000000" //3-6
                + "000000000000" //6-9
                + "000000000000" //9-12
                + "111100000000" //12-15
                + "000000000000" //15-18
                + "000000000000" //18-21
                + "000000000000"; //21-24

        timeSlot2 = "000000000000" //0-3
                + "000000000000" //3-6
                + "000000000000" //6-9
                + "000000000000" //9-12
                + "000111000000" //12-15
                + "000000000000" //15-18
                + "000000000000" //18-21
                + "000000000000"; //21-24

        timeSlot3 = "000000000000" //0-3
                + "000000000000" //3-6
                + "000000000000" //6-9
                + "000000000000" //9-12
                + "000000000000" //12-15
                + "001111111000" //15-18
                + "000000000000" //18-21
                + "000000000000"; //21-24
    }

    @BeforeEach
    void setUp() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, "meeting", Set.of("conf phone", "display")));
        rooms.add(new Room(2, "meeting", Set.of("conf phone", "display")));
        rooms.add(new Room(3, "meeting", Set.of("conf phone", "display")));
        rooms.add(new Room(4, "meeting", Set.of("conf phone", "display")));
        rooms.add(new Room(5, "meeting", Set.of("conf phone", "display", "light shading")));
        rooms.add(new Room(6, "meeting", Set.of("conf phone", "display", "light shading")));
        rooms.add(new Room(7, "meeting", Set.of("conf phone", "display", "light shading")));

        rooms.add(new Room(11, "conference", Set.of("conf phone", "projector", "light shading")));
        rooms.add(new Room(12, "conference", Set.of("conf phone", "projector", "light shading")));
        rooms.add(new Room(13, "conference", Set.of("conf phone", "projector", "light shading", "display")));
        rooms.add(new Room(14, "conference", Set.of("conf phone", "projector", "light shading", "personal mics")));

        rooms.add(new Room(21, "resting room", Set.of("soft armchair", "light shading", "ambient music")));
        rooms.add(new Room(22, "resting room", Set.of("soft armchair", "soft sofa", "ambient light", "ambient music")));

        List<Booking> bookings = new ArrayList<>();
        BookingNotifier notifier = new BookingNotifier();

        BookingObserver administrationObserver = new BookingObserver() {
            @Override
            public void update(Booking booking, String status) {
                System.out.printf("administration observer updated with new booking %d with status %s",
                        booking.getBookingId(),
                        status);
            }
        };
        BookingObserver userObserver = new BookingObserver() {
            @Override
            public void update(Booking booking, String status) {
                System.out.printf("user observer updated with new booking %d with status %s",
                        booking.getBookingId(),
                        status);
            }
        };
        notifier.addObserver(userObserver);
        notifier.addObserver(administrationObserver);

        bookingSystem = new BookingSystem(bookings, rooms, notifier);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addRoom() {
        Room room2add = new Room(8, "meeting", Set.of("conf phone", "projector", "light shading"));
        assertFalse(bookingSystem.getRoomList().contains(room2add));
        bookingSystem.addRoom(room2add);
        assertTrue(bookingSystem.getRoomList().contains(room2add));
    }

    @Test
    void removeRoom() {
        Room room2add = new Room(8, "meeting", Set.of("conf phone", "projector", "light shading"));
        bookingSystem.addRoom(room2add);
        assertTrue(bookingSystem.getRoomList().contains(room2add));
        bookingSystem.removeRoom(8);
        assertFalse(bookingSystem.getRoomList().contains(room2add));
    }

    @Test
    void bookRoom() {
        Booking booking = bookingSystem.bookRoom(7, date1, timeSlot1);
        Booking newBooking = bookingSystem.getBookingList().get(0);

        assertEquals(booking, newBooking);
        assertEquals(7, newBooking.getRoom().getRoomNumber());
        assertEquals(newBooking.getTimeSlot(), timeSlot1);

        assertNull(bookingSystem.bookRoom(7, date1, timeSlot2));
    }

    @Test
    void cancelBooking() {
        Booking booking = bookingSystem.bookRoom(7, date1, timeSlot1);
        assertEquals(7, booking.getRoom().getRoomNumber());

        bookingSystem.cancelBooking(booking.getBookingId());

        assertFalse(bookingSystem.getBookingList().contains(booking));
    }

    @Test
    void findAvailableRooms() {
        List<Room> availableRooms0 = bookingSystem
                .findAvailableRooms(date1, timeSlot2, Set.of("display", "conf phone"));
        bookingSystem.bookRoom(13, date1, timeSlot1);
        List<Room> availableRooms1 = bookingSystem
                .findAvailableRooms(date1, timeSlot2, Set.of("display", "conf phone"));

        ArrayList<Room> rooms = new ArrayList<>(availableRooms0);
        rooms.removeAll(availableRooms1);
        assertEquals(13, rooms.get(0).roomNumber);
    }

    @Test
    void findBookingsForDate() {
        Booking b1 = bookingSystem.bookRoom(5, date1, timeSlot1);
        Booking b2 = bookingSystem.bookRoom(6, date1, timeSlot1);
        Booking b3 = bookingSystem.bookRoom(5, date2, timeSlot1);
        List<Booking> bookingsForDate = bookingSystem.findBookingsForDate(date1);
        assertTrue(bookingsForDate.containsAll(List.of(b1, b2)));
        assertEquals(2, bookingsForDate.size());
    }
}