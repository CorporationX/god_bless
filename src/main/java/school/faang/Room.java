package school.faang;

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