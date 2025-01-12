package school.faang.task_44808.room.domain.model;

import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;
import school.faang.task_44808.room.domain.validator.RoomValidator;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class RoomFactory {
    private final RoomValidator roomValidator;
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public RoomFactory(RoomValidator roomValidator, int initialCounter) {
        this.roomValidator = roomValidator;
        this.idCounter.set(initialCounter);
    }

    public Room createRoom(RoomType type, Set<RoomAmenity> amenities) {
        roomValidator.validateRoom(type, amenities);
        return new Room(getNextId(), type, amenities);
    }

    private synchronized int getNextId() {
        return idCounter.getAndIncrement();
    }
}
