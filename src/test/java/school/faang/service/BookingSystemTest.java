package school.faang.service;

import school.faang.model.Booking;
import school.faang.model.Room;
import school.faang.observer.BookingNotifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingSystemTest {
    private BookingSystem bookingSystem;
    private Room room1;
    private Room room2;

    @BeforeEach
    void setUp() {
        bookingSystem = new BookingSystem();
        room1 = new Room(101, "Conference Room", Set.of("Projector", "WiFi"));
        room2 = new Room(102, "Meeting Room", Set.of("Whiteboard", "WiFi"));
        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);
    }

    @Test
    void testAddRoom() {
        Room room3 = new Room(103, "Private Office", Set.of("WiFi"));
        bookingSystem.addRoom(room3);
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025-02-06", "10:00-11:00", Set.of("WiFi"));
        assertEquals(3, availableRooms.size());
    }

    @Test
    void testRemoveRoom() {
        bookingSystem.removeRoom(101);
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025-02-06", "10:00-11:00", Set.of("WiFi"));
        assertEquals(1, availableRooms.size());
    }

    @Test
    void testBookRoomSuccess() {
        Booking booking = bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        assertNotNull(booking);
        assertEquals(101, booking.getRoom().getRoomNumber());
    }

    @Test
    void testBookRoomAlreadyBooked() {
        bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00")
        );
        assertEquals("Room not available for the given time and date.", exception.getMessage());
    }

    @Test
    void testCancelBooking() {
        Booking booking = bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        bookingSystem.cancelBooking(booking.getBookingId());
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025-02-06", "10:00-11:00", Set.of("WiFi"));
        assertTrue(availableRooms.contains(room1));
    }

    @Test
    void testFindAvailableRoomsNoMatchingAmenities() {
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025-02-06", "10:00-11:00", Set.of("NonExistentAmenity"));
        assertTrue(availableRooms.isEmpty());
    }

    @Test
    void testFindAvailableRoomsPartialMatch() {
        bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025-02-06", "10:00-11:00", Set.of("WiFi"));
        assertTrue(availableRooms.contains(room2));
    }

    @Test
    void testFindBookingsForDate() {
        bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        bookingSystem.bookRoom(102, "2025-02-06", "11:00-12:00");
        List<Booking> bookingsForDate = bookingSystem.findBookingsForDate("2025-02-06");
        assertEquals(2, bookingsForDate.size());
    }

    @Test
    void testNoBookingsForDate() {
        List<Booking> bookingsForDate = bookingSystem.findBookingsForDate("2025-02-07");
        assertTrue(bookingsForDate.isEmpty());
    }

    @Test
    void testNotifierIntegration() {
        BookingNotifier notifier = bookingSystem.getNotifier();
        Admin admin = new Admin("TestAdmin");
        notifier.addObserver(admin);

        Booking booking = bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        notifier.notifyObservers(booking, "Booked");

        bookingSystem.cancelBooking(booking.getBookingId());
        notifier.notifyObservers(booking, "Cancelled");
    }
}
