package school.faang.sprint_1.task_44738;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BookingSystemTest {
    private BookingSystem bookingSystem;
    private Room room1;
    private Room room2;
    private Date dateBegin;
    private Date dateEnd;

    @BeforeEach
    void setUp() {
        bookingSystem = new BookingSystem();

        room1 = new Room("Room 1", Set.of("WiFi", "TV"));
        room2 = new Room("Room 2", Set.of("WiFi"));

        dateBegin = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000); // Завтра
        dateEnd = new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000); // Послезавтра

        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);
    }

    @Test
    void addRoom_shouldAddRoom() {
        Room room3 = new Room("Room 3", Set.of("WiFi", "TV", "AC"));
        bookingSystem.addRoom(room3);

        List<Room> availableRooms = bookingSystem.findAvailableRooms(dateBegin, dateEnd, Set.of());
        assertTrue(availableRooms.contains(room3));
    }

    @Test
    void removeRoom_shouldRemoveRoom() {
        bookingSystem.removeRoom(room1);

        List<Room> availableRooms = bookingSystem.findAvailableRooms(dateBegin, dateEnd, Set.of());
        assertFalse(availableRooms.contains(room1));
    }

    @Test
    void bookRoom_shouldBookRoomIfAvailable() {
        Booking booking = bookingSystem.bookRoom(room1.getId(), dateBegin, dateEnd);

        assertEquals(room1, booking.getRoom());
    }

    @Test
    void bookRoom_shouldReturnNullIfRoomNotAvailable() {
        bookingSystem.bookRoom(room1.getId(), dateBegin, dateEnd);

        Booking overlappingBooking = bookingSystem.bookRoom(room1.getId(), dateBegin, dateEnd);
        assertNull(overlappingBooking);
    }

    @Test
    void removeBooking_shouldRemoveExistingBooking() {
        Booking booking = bookingSystem.bookRoom(room1.getId(), dateBegin, dateEnd);

        boolean isRemoved = bookingSystem.removeBooking(booking.getId());
        List<Booking> bookingsForDate = bookingSystem.findBookingsForDate(dateBegin);

        assertTrue(isRemoved);
        assertFalse(bookingsForDate.contains(booking));
    }

    @Test
    void removeBooking_shouldReturnFalseIfBookingDoesNotExist() {
        boolean isRemoved = bookingSystem.removeBooking(999);
        assertFalse(isRemoved);
    }

    @Test
    void findAvailableRooms_shouldReturnRoomsMatchingAmenitiesAndAvailability() {
        Set<String> requiredAmenities = Set.of("WiFi");

        List<Room> availableRooms = bookingSystem.findAvailableRooms(dateBegin, dateEnd, requiredAmenities);

        assertTrue(availableRooms.contains(room1));
        assertTrue(availableRooms.contains(room2));
    }

    @Test
    void findAvailableRooms_shouldExcludeRoomsWithoutRequiredAmenities() {
        Set<String> requiredAmenities = Set.of("TV");

        List<Room> availableRooms = bookingSystem.findAvailableRooms(dateBegin, dateEnd, requiredAmenities);

        assertTrue(availableRooms.contains(room1));
        assertFalse(availableRooms.contains(room2));
    }

    @Test
    void findBookingsForDate_shouldReturnBookingsForSpecificDate() {
        Booking booking = bookingSystem.bookRoom(room1.getId(), dateBegin, dateEnd);

        List<Booking> bookingsForDate = bookingSystem.findBookingsForDate(dateBegin);
        assertTrue(bookingsForDate.contains(booking));
    }

    @Test
    void findBookingsForDate_shouldReturnEmptyListIfNoBookingsForDate() {
        Date unrelatedDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000); // Вчера

        List<Booking> bookingsForDate = bookingSystem.findBookingsForDate(unrelatedDate);
        assertTrue(bookingsForDate.isEmpty());
    }
}