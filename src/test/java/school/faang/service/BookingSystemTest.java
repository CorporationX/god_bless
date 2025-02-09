package school.faang.service;

import school.faang.model.Booking;
import school.faang.model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
        List<Room> availableRooms = bookingSystem.findAvailableRooms(
                "2025-02-06", "10:00-11:00", Set.of("WiFi")
        );
        assertEquals(3, availableRooms.size());

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> bookingSystem.addRoom(room3));
        assertEquals("Room with this number already exists.", exception.getMessage());
    }

    @Test
    void testRemoveRoom() {
        bookingSystem.removeRoom(101);
        List<Room> availableRooms = bookingSystem.findAvailableRooms(
                "2025-02-06", "10:00-11:00", Set.of("WiFi")
        );
        assertEquals(1, availableRooms.size());

        bookingSystem.bookRoom(102, "2025-02-06", "10:00-11:00");
        Exception exception = assertThrows(IllegalStateException.class,
                () -> bookingSystem.removeRoom(102));
        assertEquals("Cannot remove room 102 as it has active bookings.", exception.getMessage());
    }

    @Test
    void testBookRoomAlreadyBooked() {
        bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00")
        );
        assertEquals("Room not available for the given time and date.", exception.getMessage());

        Exception nonExistentRoomException = assertThrows(IllegalArgumentException.class,
                () -> bookingSystem.bookRoom(999, "2025-02-06", "10:00-11:00")
        );
        assertEquals("Room with number 999 does not exist.", nonExistentRoomException.getMessage());
    }

    @Test
    void testFindAvailableRoomsPartialMatch() {
        bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        List<Room> availableRooms = bookingSystem.findAvailableRooms(
                "2025-02-06", "10:00-11:00", Set.of("WiFi")
        );
        assertFalse(availableRooms.contains(room1));
        assertTrue(availableRooms.contains(room2));
    }

    @Test
    void testCancelBooking() {
        Booking booking = bookingSystem.bookRoom(101, "2025-02-06", "10:00-11:00");
        bookingSystem.cancelBooking(booking.getBookingId());

        List<Room> availableRooms = bookingSystem.findAvailableRooms(
                "2025-02-06", "10:00-11:00", Set.of("WiFi")
        );
        assertTrue(availableRooms.contains(room1));

        assertDoesNotThrow(() -> bookingSystem.cancelBooking(999));
    }
}
