package school.faang.BJS236059;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Room {
    private int roomNumber;
    private List<Food> food;

    public void addFood(Food meal) {
        food.add(meal);
    }
}
