package school.faang.bjs244725;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@Getter
public class Room {
    private static final Logger logger = LoggerFactory.getLogger(Room.class);

    private final int roomId;
    private final String type;
    private final Set<String> amenities;

    public Room(int roomId, String type, Set<String> amenities) {
        if (roomId <= 0) {
            throw new IllegalArgumentException("Room ID must be a positive number.");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Room type cannot be null or empty.");
        }
        if (amenities == null || amenities.isEmpty()) {
            throw new IllegalArgumentException("Amenities cannot be null or empty.");
        }
        this.roomId = roomId;
        this.type = type;
        this.amenities = amenities;
        logger.info("Room created: {}", this);
    }

    @Override
    public String toString() {
        return String.format("Room{roomId=%d, type='%s', amenities=%s}", roomId, type, amenities);
    }
}