package school.faang.bjs244740;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs244740.observers.BookingObserver;
import school.faang.bjs244740.observers.HotelObserver;
import school.faang.bjs244740.observers.UserObserver;
import java.util.ArrayList;
import java.util.List;

public class BookingSystemTest {
    private BookingSystem bookingSystem;

    private final List<BookingObserver> bookingObservers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        bookingSystem = new BookingSystem();
        bookingObservers.addAll(List.of(new HotelObserver(), new UserObserver()));
        bookingSystem.getBookingNotifier().addObserver(bookingObservers.get(0));
        bookingSystem.getBookingNotifier().addObserver(bookingObservers.get(1));
    }

    @Test
    void addRoomTest() {
        RoomData data = RoomData.ROOM1;
        createRoom(data);
    }

    @Test
    void addRoomAlreadyExistsTest() {
        RoomData data = RoomData.ROOM1;
        createRoom(data);

        try {
            createRoom(data);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "Room with id " + data.getRoomId() + " already exists");
        }
    }

    @Test
    void removeRoomTest() {
        RoomData data = RoomData.ROOM1;
        createRoom(data);

        bookingSystem.removeRoom(data.getRoomId());
        Assertions.assertEquals(0, bookingSystem.getRooms().size());
    }

    @Test
    void bookRoomTest() {
        RoomData data = RoomData.ROOM1;
        createRoom(data);

        checkAndBookRoom(data);
    }

    @Test
    void bookRoomAlreadyBookedTest() {
        RoomData data = RoomData.ROOM1;
        createRoom(data);

        checkAndBookRoom(data);
        try {
            checkAndBookRoom(data);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "Room already booked");
        }
    }

    @Test
    void cancelBookingTest() {
        RoomData data = RoomData.ROOM1;

        createRoom(data);
        Booking booking = checkAndBookRoom(data);
        bookingSystem.cancelBooking(booking.getBookingId());
        Assertions.assertEquals(0, bookingSystem.getBookings().size());
        Assertions.assertEquals("Canceled", bookingObservers.get(0).getStatus());
        Assertions.assertEquals("Canceled", bookingObservers.get(1).getStatus());
    }

    @Test
    void findAvailableRoomsTest() {
        RoomData room1 = RoomData.ROOM1;
        RoomData room2 = RoomData.ROOM2;

        createRoom(room1);
        createRoom(room2);
        checkAndBookRoom(room1);

        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025", "20:00", room2.getAmenities());
        Assertions.assertEquals(1, availableRooms.size());
    }

    @Test
    void findAvailableRoomsNotAvailableTest() {
        RoomData room1 = RoomData.ROOM1;
        RoomData room2 = RoomData.ROOM2;

        createRoom(room1);
        createRoom(room2);
        checkAndBookRoom(room1);
        checkAndBookRoom(room2);

        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025", "20:00", room2.getAmenities());
        Assertions.assertEquals(0, availableRooms.size());
    }

    @Test
    void findAvailableRoomsNotFoundForAmenitiesTest() {
        RoomData room1 = RoomData.ROOM1;
        RoomData room2 = RoomData.ROOM2;

        createRoom(room1);
        createRoom(room2);
        checkAndBookRoom(room1);

        List<Room> availableRooms = bookingSystem.findAvailableRooms("2025", "20:00", RoomData.ROOM3.getAmenities());
        Assertions.assertEquals(0, availableRooms.size());
    }

    private void createRoom(RoomData data) {
        bookingSystem.addRoom(data.createRoom());
        Assertions.assertEquals(data.createRoom(), bookingSystem.getRooms().get(data.getRoomId()));
    }

    private Booking checkAndBookRoom(RoomData data) throws IllegalArgumentException {
        int size = bookingSystem.getBookings().size();
        Booking booking = bookingSystem.bookRoom(data.getRoomId(), "2025", "20:00");
        Assertions.assertEquals(size + 1, bookingSystem.getBookings().size());
        return booking;
    }
}
