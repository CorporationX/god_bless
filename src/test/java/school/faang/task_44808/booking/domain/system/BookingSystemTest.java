package school.faang.task_44808.booking.domain.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_44808.booking.domain.model.BookingFactory;
import school.faang.task_44808.booking.domain.validator.BookingValidator;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;
import school.faang.task_44808.room.domain.model.Room;
import school.faang.task_44808.room.domain.model.RoomFactory;
import school.faang.task_44808.room.domain.validator.RoomValidator;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("BookingSystemTest: Tests for bookRoom method")
class BookingSystemTest {

    @Test
    @DisplayName("bookRoom: should book a room successfully when it is available")
    void bookRoom_shouldBookRoomWhenAvailable() {
        // Arrange
        BookingFactory bookingFactory = new BookingFactory(new BookingValidator(date -> {
        }), 1);
        BookingSystem bookingSystem = new BookingSystem(bookingFactory);
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        Room room = roomFactory.createRoom(RoomType.TRIPLE, Collections.singleton(RoomAmenity.TV));
        bookingSystem.getRooms().add(room);

        // Act
        boolean result = bookingSystem.bookRoom(1, "2023-11-10", "09:00-10:00");

        // Assert
        assertTrue(result, "Room should be booked successfully when it is available");
    }

    @Test
    @DisplayName("bookRoom: should not book a room when it is already booked for the same slot")
    void bookRoom_shouldNotBookRoomWhenAlreadyBooked() {
        // Arrange
        BookingFactory bookingFactory = new BookingFactory(new BookingValidator(date -> {
        }), 1);
        BookingSystem bookingSystem = new BookingSystem(bookingFactory);
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        Room room = roomFactory.createRoom(RoomType.TRIPLE, Collections.singleton(RoomAmenity.TV));
        bookingSystem.getRooms().add(room);

        bookingSystem.bookRoom(1, "2023-11-10", "09:00-10:00");

        // Act
        boolean result = bookingSystem.bookRoom(1, "2023-11-10", "09:00-10:00");

        // Assert
        assertFalse(result, "Room should not be booked when already booked for the same timeslot");
    }

    @Test
    @DisplayName("bookRoom: should throw exception when attempting to book a non-existent room")
    void bookRoom_shouldThrowExceptionWhenRoomDoesNotExist() {
        // Arrange
        BookingFactory bookingFactory = new BookingFactory(new BookingValidator(date -> {
        }), 1);
        BookingSystem bookingSystem = new BookingSystem(bookingFactory);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> bookingSystem.bookRoom(99, "2023-11-10", "09:00-10:00"),
                "Attempting to book a non-existent room should throw an exception");

        assertEquals("Room not found: 99", exception.getMessage(), "Exception should indicate that the room was not "
                + "found");
    }
}