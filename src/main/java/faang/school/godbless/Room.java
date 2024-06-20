package faang.school.godbless;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Data
public class Room {
    private String name;
    private List<Food> foodInRoom;

    public Room(String name, List<Food> foodInRoom) {
        this.name = name;
        this.foodInRoom = foodInRoom;
    }
    public List<Food> getFoodInRoom (){
        return this.foodInRoom;
    }
    public void deleteFoodInRoom() {
        foodInRoom.clear();
    }

    public String getName() {
        return this.name;
    }
}
