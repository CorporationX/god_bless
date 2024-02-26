package tom_and_jarry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Getter
@ToString
public class Room {
    private List<Food> food_in_room;
    public void addFood(Food food){
        food_in_room.add(food);
    }
    public void removeFood(Food food){
        food_in_room.remove(food);
    }
}
