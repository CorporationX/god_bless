package school.faang.task_44808.room.domain.model;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;

import java.util.Set;

@Slf4j
@Getter
@ToString
public class Room {
    private static final String ROOM_CREATION_LOG_FORMAT = "Created room: id={}, type={}, amenities={}";

    private final int id;
    private final RoomType type;
    private final Set<RoomAmenity> amenities;

    protected Room(int id, RoomType type, Set<RoomAmenity> amenities) {
        this.id = id;
        this.type = type;
        this.amenities = Set.copyOf(amenities);
        logRoomCreation();
    }

    private void logRoomCreation() {
        log.debug(ROOM_CREATION_LOG_FORMAT, id, type, amenities);
    }
}