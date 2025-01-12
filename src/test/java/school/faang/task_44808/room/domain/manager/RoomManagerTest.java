package school.faang.task_44808.room.domain.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;
import school.faang.task_44808.room.domain.model.Room;
import school.faang.task_44808.room.domain.model.RoomFactory;
import school.faang.task_44808.room.domain.validator.RoomValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("RoomManagerTest: Tests for the addRoom method")
class RoomManagerTest {

    @Test
    @DisplayName("addRoom: should add a new room successfully")
    void addRoom_shouldAddNewRoomSuccessfully() {
        // Arrange
        RoomManager roomManager = new RoomManager();
        Set<RoomAmenity> amenities = new HashSet<>(Set.of(RoomAmenity.WIFI, RoomAmenity.TV));
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        Room room = roomFactory.createRoom(RoomType.SINGLE, amenities);

        // Act
        roomManager.addRoom(room);
        List<Room> allRooms = roomManager.getAllRooms();

        // Assert
        assertEquals(1, allRooms.size(), "Room list size should be 1 after adding a room.");
        assertTrue(allRooms.contains(room), "Added room should be present in the room list.");
    }

    @Test
    @DisplayName("addRoom: should not add a duplicate room if ID already exists")
    void addRoom_shouldNotAddDuplicateRoomIfIdAlreadyExists() {
        // Arrange
        RoomManager roomManager = new RoomManager();
        Set<RoomAmenity> amenities = new HashSet<>(Set.of(RoomAmenity.WIFI));
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        Room room1 = roomFactory.createRoom(RoomType.SINGLE, amenities);
        Room room2 = roomFactory.createRoom(RoomType.TRIPLE, amenities);

        // Act
        roomManager.addRoom(room1);
        roomManager.addRoom(room2);
        List<Room> allRooms = roomManager.getAllRooms();

        // Assert
        assertEquals(2, allRooms.size(), "Room list size should remain 1 if duplicate ID is added.");
        assertTrue(allRooms.contains(room1), "The room with the original ID should still exist.");
    }

    @Test
    @DisplayName("addRoom: should throw exception if room is null")
    void addRoom_shouldThrowExceptionIfRoomIsNull() {
        // Arrange
        RoomManager roomManager = new RoomManager();

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> roomManager.addRoom(null),
                "Adding a null room should throw an IllegalArgumentException.");
        assertEquals("Room cannot be null", thrown.getMessage(), "Exception message should match.");
    }

    @Test
    @DisplayName("addRoom: should successfully handle multiple different rooms")
    void addRoom_shouldSuccessfullyHandleMultipleDifferentRooms() {
        // Arrange
        RoomManager roomManager = new RoomManager();
        Set<RoomAmenity> amenities1 = new HashSet<>(Set.of(RoomAmenity.WIFI, RoomAmenity.TV));
        Set<RoomAmenity> amenities2 = new HashSet<>(Set.of(RoomAmenity.BATHROOM, RoomAmenity.KITCHEN));
        RoomFactory roomFactory = new RoomFactory(new RoomValidator(), 1);
        Room room1 = roomFactory.createRoom(RoomType.DOUBLE, amenities1);
        Room room2 = roomFactory.createRoom(RoomType.SINGLE, amenities2);

        // Act
        roomManager.addRoom(room1);
        roomManager.addRoom(room2);
        List<Room> allRooms = roomManager.getAllRooms();

        // Assert
        assertEquals(2, allRooms.size(), "Room list size should be 2 after adding two valid rooms.");
        assertTrue(allRooms.contains(room1), "First added room should be present in the room list.");
        assertTrue(allRooms.contains(room2), "Second added room should be present in the room list.");
    }
}