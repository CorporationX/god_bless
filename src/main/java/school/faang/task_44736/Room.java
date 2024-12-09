package school.faang.task_44736;

import lombok.Getter;

import java.util.Set;

@Getter
public class Room {
    private int roomId;
    private String type;
    private Set<String> amenities;
    private static int counterId;

    public Room(String type, Set<String> amenities) {
        this.roomId = ++counterId;
        this.type = type;
        this.amenities = amenities;
    }
}
