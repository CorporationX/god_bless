package Sprint_4_Mice_are_very_nice;

import lombok.Data;

import java.util.List;
@Data
public class Room {
    private String roomName;
    private List<Food> foodForRoom;

    public Room(String roomName, List<Food> foodForRoom) {
        this.roomName = roomName;
        this.foodForRoom = foodForRoom;
    }
}
