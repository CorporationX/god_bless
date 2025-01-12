package school.faang.task_44808.booking.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BookingDateValidatorTest: Tests for BookingDateValidator")
class BookingDateValidatorTest {

    @Test
    @DisplayName("validate: should throw exception when booking date is in the past")
    void validate_shouldThrowExceptionWhenBookingDateIsInThePast() {
        // Arrange
        BookingDateValidator validator = new BookingDateValidator();
        LocalDate pastDate = LocalDate.now().minusDays(1);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(pastDate),
                "Expected exception when booking date is in the past"
        );

        // Verify
        assert exception.getMessage().contains("Booking date cannot be in the past");
    }

    @Test
    @DisplayName("validate: should throw exception when booking date exceeds maximum days in the future")
    void validate_shouldThrowExceptionWhenBookingDateExceedsMaximumDaysInFuture() {
        // Arrange
        BookingDateValidator validator = new BookingDateValidator();
        LocalDate futureDate = LocalDate.now().plusDays(BookingDateValidator.MAX_DAYS_IN_ADVANCE + 1);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(futureDate),
                "Expected exception when booking date exceeds maximum allowed days in the future"
        );

        // Verify
        assert exception.getMessage().contains("Booking date cannot be more than");
    }

    @Test
    @DisplayName("validate: should not throw exception for a valid booking date")
    void validate_shouldNotThrowExceptionForValidBookingDate() {
        // Arrange
        BookingDateValidator validator = new BookingDateValidator();
        LocalDate validDate = LocalDate.now().plusDays(10);

        // Act & Assert
        try {
            validator.validate(validDate);
        } catch (IllegalArgumentException e) {
            throw new AssertionError("Unexpected exception: " + e.getMessage());
        }
    }
}