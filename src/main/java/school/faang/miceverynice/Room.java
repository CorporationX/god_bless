package school.faang.miceverynice;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private final String roomName;
    private final List<Food> foods;

    public Room(String roomName, List<Food> foods) {
        this.roomName = roomName;
        this.foods = foods;
    }
}
