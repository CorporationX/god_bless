package school.faang.task_44808.room.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("RoomValidatorTest: Unit tests for the RoomValidator")
class RoomValidatorTest {

    private final RoomValidator roomValidator = new RoomValidator();

    @Test
    @DisplayName("validateRoom: should throw IllegalArgumentException when room type is null")
    void validateRoom_shouldThrowExceptionWhenRoomTypeIsNull() {
        // Arrange
        RoomType roomType = null;
        Set<RoomAmenity> amenities = EnumSet.of(RoomAmenity.BATHROOM, RoomAmenity.WIFI);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> roomValidator.validateRoom(roomType, amenities),
                "Expected validateRoom to throw IllegalArgumentException when room type is null");
        assert exception.getMessage().equals("Room type is null");
    }

    @Test
    @DisplayName("validateRoom: should throw IllegalArgumentException when amenities set is null")
    void validateRoom_shouldThrowExceptionWhenAmenitiesSetIsNull() {
        // Arrange
        RoomType roomType = RoomType.DOUBLE;
        Set<RoomAmenity> amenities = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> roomValidator.validateRoom(roomType, amenities),
                "Expected validateRoom to throw IllegalArgumentException when amenities set is null");
        assert exception.getMessage().equals("Room amenities are null");
    }

    @Test
    @DisplayName("validateRoom: should throw IllegalArgumentException when amenities set is empty")
    void validateRoom_shouldThrowExceptionWhenAmenitiesSetIsEmpty() {
        // Arrange
        RoomType roomType = RoomType.SINGLE;
        Set<RoomAmenity> amenities = EnumSet.noneOf(RoomAmenity.class);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> roomValidator.validateRoom(roomType, amenities),
                "Expected validateRoom to throw IllegalArgumentException when amenities set is empty");
        assert exception.getMessage().equals("Room amenities are empty");
    }

    @Test
    @DisplayName("validateRoom: should throw IllegalArgumentException when amenities contain null")
    void validateRoom_shouldThrowExceptionWhenAmenitiesContainNull() {
        // Arrange
        RoomType roomType = RoomType.TRIPLE;
        Set<RoomAmenity> amenities = new HashSet<>(EnumSet.of(RoomAmenity.TV));
        amenities.add(null);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> roomValidator.validateRoom(roomType, amenities),
                "Expected validateRoom to throw IllegalArgumentException when amenities contain null");
        assert exception.getMessage().equals("Room amenities contain null");
    }

    @Test
    @DisplayName("validateRoom: should not throw any exception for valid room type and amenities")
    void validateRoom_shouldNotThrowExceptionForValidRoomTypeAndAmenities() {
        // Arrange
        RoomType roomType = RoomType.SUITE;
        Set<RoomAmenity> amenities = EnumSet.of(RoomAmenity.BATHROOM, RoomAmenity.TV, RoomAmenity.WIFI);

        // Act & Assert
        roomValidator.validateRoom(roomType, amenities);
    }
}