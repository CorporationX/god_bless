package school.faang.task_44808.room.domain.manager;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.room.domain.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ToString
public class RoomManager {
    private final Map<Integer, Room> rooms = new HashMap<>();

    public RoomManager() {
        log.debug("RoomManager initialized");
    }

    public void addRoom(Room room) {
        ensureRoomNotNull(room);

        if (doesRoomExist(room.getId())) {
            log.warn("Room with id {} already exists", room.getId());
            return;
        }

        rooms.put(room.getId(), room);
        log.info("Room successfully added: {}", room);
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    public Room getRoomById(int id) {
        final Room room = rooms.get(id);

        if (room == null) {
            log.warn("Room with id {} does not exist", id);
        }

        return room;
    }

    public void printAllRooms() {
        if (rooms.isEmpty()) {
            log.warn("No rooms exist");
            return;
        }

        rooms.forEach((id, room) -> log.info("Room: {}", room));
    }

    public void removeRoom(Room room) {
        ensureRoomNotNull(room);

        if (!rooms.containsKey(room.getId())) {
            logRoomRemoval(room);
            return;
        }

        rooms.remove(room.getId());
        logRoomRemoval(room);
    }

    public void removeRoomById(int roomId) {
        final Room removedRoom = rooms.remove(roomId);
        logRoomRemoval(removedRoom);
    }

    private boolean doesRoomExist(int roomId) {
        return rooms.containsKey(roomId);
    }

    private void ensureRoomNotNull(Room room) {
        if (room == null) {
            log.error("Validation failed: Room is null");
            throw new IllegalArgumentException("Room cannot be null");
        }
    }

    private void logRoomRemoval(Room room) {
        if (room != null) {
            log.info("Room successfully removed: {}", room);
        } else {
            log.warn("Cannot remove: Room does not exist or was null");
        }
    }
}
