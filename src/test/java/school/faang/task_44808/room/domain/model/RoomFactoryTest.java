package school.faang.task_44808.room.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;
import school.faang.task_44808.room.domain.validator.RoomValidator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("RoomFactoryTest: Tests for RoomFactory")
class RoomFactoryTest {

    @Test
    @DisplayName("createRoom: should create room successfully with valid input")
    void createRoom_shouldCreateRoomSuccessfully() {
        // Arrange
        RoomValidator roomValidator = new RoomValidator();
        RoomFactory roomFactory = new RoomFactory(roomValidator, 1);
        RoomType roomType = RoomType.DOUBLE;
        Set<RoomAmenity> amenities = Set.of(RoomAmenity.BATHROOM, RoomAmenity.WIFI);

        // Act
        Room room = roomFactory.createRoom(roomType, amenities);

        // Assert
        assertAll("Verify room properties",
                () -> assertEquals(1, room.getId(), "Room ID should be 1"),
                () -> assertEquals(RoomType.DOUBLE, room.getType(), "Room type should match"),
                () -> assertEquals(Set.of(RoomAmenity.BATHROOM, RoomAmenity.WIFI), room.getAmenities(),
                        "Room amenities should match")
        );
    }

    @Test
    @DisplayName("createRoom: should throw exception for invalid room type and amenities")
    void createRoom_shouldThrowExceptionForInvalidInputs() {
        // Arrange
        RoomValidator roomValidator = new RoomValidator();
        RoomFactory roomFactory = new RoomFactory(roomValidator, 1);
        RoomType roomType = null; // Invalid room type
        Set<RoomAmenity> amenities = null; // Invalid amenities

        // Act & Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> roomFactory.createRoom(roomType, amenities),
                "Expected createRoom to throw an IllegalArgumentException for invalid inputs"
        );
        assertEquals("Room type is null", exception.getMessage(),
                "Exception message should match for invalid room type");
    }

    @Test
    @DisplayName("createRoom: should increment room ID sequentially")
    void createRoom_shouldIncrementRoomIdSequentially() {
        // Arrange
        RoomValidator roomValidator = new RoomValidator();
        RoomFactory roomFactory = new RoomFactory(roomValidator, 5);
        RoomType roomType1 = RoomType.SUITE;
        Set<RoomAmenity> amenities1 = Set.of(RoomAmenity.TV, RoomAmenity.KITCHEN);
        RoomType roomType2 = RoomType.TRIPLE;
        Set<RoomAmenity> amenities2 = Set.of(RoomAmenity.WIFI, RoomAmenity.WATER_COURT);

        // Act
        Room room1 = roomFactory.createRoom(roomType1, amenities1);
        Room room2 = roomFactory.createRoom(roomType2, amenities2);

        // Assert
        assertAll("Verify room IDs",
                () -> assertEquals(5, room1.getId(), "First room ID should be 5"),
                () -> assertEquals(6, room2.getId(), "Second room ID should be 6")
        );
    }
}