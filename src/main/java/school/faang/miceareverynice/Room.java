package school.faang.miceareverynice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {

    private List<Food> foodInThisRoom = new ArrayList<>();

    public void addFood(Food food) {
        foodInThisRoom.add(food);
    }

    public void removeFood(int i) {
        foodInThisRoom.remove(i);
    }

}
