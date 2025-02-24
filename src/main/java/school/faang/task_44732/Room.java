package school.faang.task_44732;

import lombok.Getter;

import java.util.Set;

@Getter
public class Room {
    private int roomId;
    private String type;
    private Set<String> amenities;

    public Room(int roomId, String type, Set<String> amenities) {
        this.roomId = roomId;
        this.type = type;
        this.amenities = amenities;
    }
}
