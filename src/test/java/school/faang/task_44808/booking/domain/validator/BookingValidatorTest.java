package school.faang.task_44808.booking.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_44808.booking.domain.timeslot.BookingDate;
import school.faang.task_44808.booking.domain.timeslot.BookingTime;
import school.faang.task_44808.common.validator.Validator;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;
import school.faang.task_44808.room.domain.model.Room;
import school.faang.task_44808.room.domain.model.RoomFactory;
import school.faang.task_44808.room.domain.validator.RoomValidator;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BookingValidatorTest: Testing validateBooking functionality")
class BookingValidatorTest {

    @Test
    @DisplayName("validateBooking: should pass with valid date")
    void validateBooking_shouldPassWithValidDate() {
        // Arrange
        Validator<LocalDate> dateValidator = date -> {
            if (date.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Date cannot be in the past.");
            }
        };
        BookingValidator bookingValidator = new BookingValidator(dateValidator);

        BookingDate bookingDate = new BookingDate(LocalDate.now().plusDays(1).toString());
        BookingTime bookingTime = new BookingTime("10:00-12:00");
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        Room room = roomFactory.createRoom(RoomType.SINGLE, Set.of(RoomAmenity.KITCHEN));

        // Act & Assert
        assertDoesNotThrow(() -> bookingValidator.validateBooking(room, bookingDate, bookingTime),
                "Validation should not throw an exception for a valid date.");
    }

    @Test
    @DisplayName("validateBooking: should fail with past date")
    void validateBooking_shouldFailWithPastDate() {
        // Arrange
        Validator<LocalDate> dateValidator = date -> {
            if (date.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Date cannot be in the past.");
            }
        };
        BookingValidator bookingValidator = new BookingValidator(dateValidator);

        BookingDate bookingDate = new BookingDate(LocalDate.now().minusDays(1).toString());
        BookingTime bookingTime = new BookingTime("10:00-12:00");
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        Room room = roomFactory.createRoom(RoomType.SINGLE, Set.of(RoomAmenity.KITCHEN));

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> bookingValidator.validateBooking(room, bookingDate, bookingTime),
                "Validation should throw an exception for a past date.");
    }
}