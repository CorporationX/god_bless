package school.faang.sprint_1.task_44750;

import java.util.Set;

public class Room {
    private final int roomId;
    private final String type;
    private final Set<String> amenities;

    public Room(int roomId, String type, Set<String> amenities) {
        this.roomId = roomId;
        this.type = type;
        this.amenities = amenities;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public Set<String> getAmenities() {
        return amenities;
    }

    @Override
    public String toString() {
        return "Room{"
                + "roomId=" + roomId
                + ", type='" + type + '\''
                + ", amenities=" + amenities
                + '}';
    }
}
