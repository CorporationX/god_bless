package school.faang.organization_system;

import lombok.Data;
import java.util.Set;

@Data
public class Room {
    private static int countRoom = 0;
    private int roomNumber;
    private final String type;
    private final Set<String> amenities;

    public Room(int roomNumber, String type, Set<String> amenities) {
        this.roomNumber = ++countRoom;
        this.type = type;
        this.amenities = amenities;
    }
}
