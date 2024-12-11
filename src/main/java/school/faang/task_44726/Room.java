package school.faang.task_44726;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
public class Room {

    private static int currentMaxRoomId = 0;
    private int roomId;
    private String type;
    private Set<String> amenities;

    @Builder
    public Room(String type, Set<String> amenities) {
        this.roomId = ++currentMaxRoomId;

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Room id can not be a negative value");
        }

        if (amenities.size() == 0) {
            throw new IllegalArgumentException("Add at least one amenity for the room");
        }
        this.type = type;
        this.amenities = amenities;
    }
}
