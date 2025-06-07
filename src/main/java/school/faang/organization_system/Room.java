package school.faang.organization_system;

import java.util.HashMap;
import java.util.Set;

public class Room {
    private int countRoom = 0;
    private int roomNumber;
    private final String type;
    private final Set<String> amenities= new HashMap;

    public Room(int roomNumber, String type) {
        this.roomNumber = ++countRoom;
        this.type = type;
    }
}
