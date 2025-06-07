package school.faang.bjs2_79723_booking_system.booking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_79723_booking_system.observer.BookingObserver;
import school.faang.bjs2_79723_booking_system.observer.EmailNotificationObserver;
import school.faang.bjs2_79723_booking_system.observer.WebhookNotificationObserver;
import school.faang.bjs2_79723_booking_system.room.Room;
import school.faang.bjs2_79723_booking_system.room.RoomAmenity;
import school.faang.bjs2_79723_booking_system.room.RoomType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingSystemTest {
    private static BookingSystem bookingSystem = new BookingSystem();
    private static final BookingNotifier bookingNotifier = new BookingNotifier();
    private static final Room roomBasicNr1 = new Room(1, RoomType.CONFERENCE, null);
    private static final Room roomTvNr2 = new Room(2, RoomType.CONFERENCE, Set.of(RoomAmenity.TV));
    private static final BookingObserver emailObserver = mock(EmailNotificationObserver.class);
    private static final BookingObserver webhookObserver = mock(WebhookNotificationObserver.class);


    @BeforeAll
    static void setUp() {
        bookingNotifier.addObserver(emailObserver);
        bookingNotifier.addObserver(webhookObserver);
    }

    @AfterEach
    void afterEach() {
        bookingSystem = new BookingSystem();
    }

    @Test
    void shouldAddBasicRoom() {
        bookingSystem.addRoom(roomBasicNr1);
        assertEquals(roomBasicNr1, bookingSystem.getRegisteredRoomByNumber(roomBasicNr1.getRoomNumber()));
    }

    @Test
    void shouldBookBasicRoomAndCallObservers() {
        bookingSystem.addRoom(roomBasicNr1);
        Booking newBooking = bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        assertEquals(newBooking.getRoom().getRoomNumber(), roomBasicNr1.getRoomNumber());
        verify(emailObserver).update(newBooking, BookingStatus.CREATED);
        verify(webhookObserver).update(newBooking, BookingStatus.CREATED);
    }

    @Test
    void shouldBookRoomWithAmenity() {
        bookingSystem.addRoom(roomTvNr2);
        Booking newBooking = bookingSystem.bookRoom(roomTvNr2.getRoomNumber(), "2025-01-01", "12:00");
        assertEquals(newBooking.getRoom().getRoomNumber(), roomTvNr2.getRoomNumber());
    }

    @Test
    void shouldBookTwoRooms() {
        bookingSystem.addRoom(roomBasicNr1);
        bookingSystem.addRoom(roomTvNr2);
        Booking newBookingBasic = bookingSystem.bookRoom(
                roomBasicNr1.getRoomNumber(),
                "2025-01-01", "12:00"
        );
        Booking newBookingTv = bookingSystem.bookRoom(
                roomTvNr2.getRoomNumber(),
                "2025-01-01",
                "12:00"
        );
        assertEquals(newBookingBasic.getRoom().getRoomNumber(), roomBasicNr1.getRoomNumber());
        assertEquals(newBookingTv.getRoom().getRoomNumber(), roomTvNr2.getRoomNumber());
    }

    @Test
    void shouldNotAddSameRoomTwice() {
        bookingSystem.addRoom(roomBasicNr1);
        assertFalse(bookingSystem.addRoom(roomBasicNr1));
    }

    @Test
    void shouldAllowBookingSameRoomDifferentDay() {
        bookingSystem.addRoom(roomBasicNr1);
        Booking newBooking01 = bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        Booking newBooking02 = bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-02", "12:00");
        assertNotNull(newBooking01);
        assertNotNull(newBooking02);
    }

    @Test
    void shouldAllowBookingSameRoomDifferentTime() {
        bookingSystem.addRoom(roomBasicNr1);
        Booking newBooking12 = bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        Booking newBooking13 = bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "13:00");
        assertNotNull(newBooking12);
        assertNotNull(newBooking13);
    }

    @Test
    void shouldNotAllowDoubleBooking() {
        bookingSystem.addRoom(roomBasicNr1);
        Booking newBookingFirst = bookingSystem.bookRoom(
                roomBasicNr1.getRoomNumber(),
                "2025-01-01", "12:00"
        );
        Booking newBookingDouble = bookingSystem.bookRoom(
                roomBasicNr1.getRoomNumber(),
                "2025-01-01",
                "12:00"
        );
        assertNotNull(newBookingFirst);
        assertNull(newBookingDouble);
    }

    @Test
    void shouldRemoveRoomAndNotifyObserversAndNotCrashOnRemoveAgain() {
        bookingSystem.addRoom(roomBasicNr1);
        Booking newBooking = bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        assertTrue(bookingSystem.removeRoom(roomBasicNr1.getRoomNumber()));
        assertNull(bookingSystem.getRegisteredRoomByNumber(roomBasicNr1.getRoomNumber()));
        verify(emailObserver).update(newBooking, BookingStatus.CANCELLED);
        verify(webhookObserver).update(newBooking, BookingStatus.CANCELLED);
        assertFalse(bookingSystem.removeRoom(roomBasicNr1.getRoomNumber()));
    }

    @Test
    void shouldReturnAllRoomsIfAllAvailable() {
        bookingSystem.addRoom(roomBasicNr1);
        bookingSystem.addRoom(roomTvNr2);
        bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        bookingSystem.bookRoom(roomTvNr2.getRoomNumber(), "2025-01-01", "12:00");
        assertEquals(2,
                bookingSystem.findAvailableRooms("2025-01-03", "12:00", null).size()
        );
    }

    @Test
    void shouldReturnRoomsWithOneAmenityRequired() {
        bookingSystem.addRoom(roomBasicNr1);
        bookingSystem.addRoom(roomTvNr2);
        bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        bookingSystem.bookRoom(roomTvNr2.getRoomNumber(), "2025-01-01", "12:00");
        assertEquals(1,
                bookingSystem.findAvailableRooms("2025-01-03", "12:00", Set.of(RoomAmenity.TV)).size()
        );
    }

    @Test
    void shouldReturnRoomsWithMultiAmenitiesRequired() {
        bookingSystem.addRoom(roomBasicNr1);
        bookingSystem.addRoom(roomTvNr2);
        bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        bookingSystem.bookRoom(roomTvNr2.getRoomNumber(), "2025-01-01", "12:00");
        assertEquals(0, bookingSystem.findAvailableRooms(
                        "2025-01-03",
                        "12:00",
                        Set.of(RoomAmenity.TV, RoomAmenity.CAMERA)
                ).size()
        );
    }

    @Test
    void shouldNotReturnRoomsWithAmenitiesIfBooked() {
        bookingSystem.addRoom(roomBasicNr1);
        bookingSystem.addRoom(roomTvNr2);
        bookingSystem.bookRoom(roomBasicNr1.getRoomNumber(), "2025-01-01", "12:00");
        bookingSystem.bookRoom(roomTvNr2.getRoomNumber(), "2025-01-01", "12:00");
        assertEquals(0,
                bookingSystem.findAvailableRooms("2025-01-01", "12:00", null).size()
        );
    }
}