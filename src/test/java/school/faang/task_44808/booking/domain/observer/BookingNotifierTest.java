package school.faang.task_44808.booking.domain.observer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_44808.booking.domain.enumeration.BookingStatus;
import school.faang.task_44808.booking.domain.model.Booking;
import school.faang.task_44808.booking.domain.model.BookingFactory;
import school.faang.task_44808.booking.domain.timeslot.BookingDate;
import school.faang.task_44808.booking.domain.timeslot.BookingTime;
import school.faang.task_44808.booking.domain.validator.BookingValidator;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;
import school.faang.task_44808.room.domain.model.Room;
import school.faang.task_44808.room.domain.model.RoomFactory;
import school.faang.task_44808.room.domain.validator.RoomValidator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("BookingNotifierTest: Tests for BookingNotifier notifyObservers method")
class BookingNotifierTest {

    private static final String DEFAULT_BOOKING_DATE = "2023-01-01";
    private static final String DEFAULT_BOOKING_TIME = "09:00-11:00";

    @Test
    @DisplayName("notifyObservers: should notify all observers when called")
    void notifyObservers_shouldNotifyAllObservers() {
        // Arrange
        BookingNotifier bookingNotifier = createBookingNotifier();
        TestObserver[] observers = createTestObservers();
        Booking booking = createBooking();

        bookingNotifier.addObserver(observers[0]);
        bookingNotifier.addObserver(observers[1]);

        // Act
        bookingNotifier.notifyObservers(booking, BookingStatus.BOOKED);

        // Assert
        assertTrue(observers[0].isNotified(), "Observer A should be notified");
        assertTrue(observers[1].isNotified(), "Observer B should be notified");
    }

    @Test
    @DisplayName("notifyObservers: should not notify removed observers")
    void notifyObservers_shouldNotNotifyRemovedObservers() {
        // Arrange
        BookingNotifier bookingNotifier = createBookingNotifier();
        TestObserver[] observers = createTestObservers();
        Booking booking = createBooking();

        bookingNotifier.addObserver(observers[0]);
        bookingNotifier.addObserver(observers[1]);
        bookingNotifier.removeObserver(observers[0]);

        // Act
        bookingNotifier.notifyObservers(booking, BookingStatus.CANCELLED);

        // Assert
        assertFalse(observers[0].isNotified(), "Observer A should not be notified");
        assertTrue(observers[1].isNotified(), "Observer B should still be notified");
    }

    @Test
    @DisplayName("notifyObservers: should handle an empty observers list")
    void notifyObservers_shouldHandleEmptyObserversList() {
        // Arrange
        BookingNotifier bookingNotifier = createBookingNotifier();
        Booking booking = createBooking();

        // Act & Assert (No error should occur)
        bookingNotifier.notifyObservers(booking, BookingStatus.CREATED);
    }

    // Factory method to create a BookingNotifier
    private BookingNotifier createBookingNotifier() {
        return new BookingNotifier();
    }

    // Helper method for creating a Booking
    private Booking createBooking() {
        BookingFactory bookingFactory = new BookingFactory(new BookingValidator(date -> {
        }), 1);
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);

        // Передаем хотя бы одно удобство
        Room room = roomFactory.createRoom(RoomType.SINGLE, Set.of(RoomAmenity.WIFI));
        BookingDate bookingDate = new BookingDate(DEFAULT_BOOKING_DATE);
        BookingTime bookingTime = new BookingTime(DEFAULT_BOOKING_TIME);

        return bookingFactory.createBooking(room, bookingDate, bookingTime);
    }

    // Helper method to create test observers
    private TestObserver[] createTestObservers() {
        return new TestObserver[]{new TestObserver(), new TestObserver()};
    }

    // Helper Class for Testing
    private static class TestObserver implements BookingObserver {
        private boolean notified = false;

        @Override
        public void update(Booking booking, BookingStatus status) {
            this.notified = true;
        }

        public boolean isNotified() {
            return notified;
        }
    }
}