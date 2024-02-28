package tom_and_jerry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Getter
@ToString
public class Room {
    private List<Food> foodInRoom;
    public void addFood(Food food){
        foodInRoom.add(food);
    }
    public void removeFood(Food food){
        foodInRoom.remove(food);
    }
}
