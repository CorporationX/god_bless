package school.faang.moduleone.task_43514;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public class Room {
    private static int nextId;
    private final int roomId;
    private final String type;
    private final Set<String> amenities;

    public Room(String type, Set<String> amenities) {
        this.roomId = nextId++;
        this.type = type;
        this.amenities = amenities;
    }
}
