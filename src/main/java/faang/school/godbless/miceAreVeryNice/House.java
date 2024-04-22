package faang.school.godbless.miceAreVeryNice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addFood(Food food) {
        collectedFood.add(food);
    }

    public void collectFood(int roomIndexToStart) {
        for (int i = roomIndexToStart; i <= (roomIndexToStart + 2); i++) {
            if (i < rooms.size()) {
                List<Food> roomFoods = rooms.get(i).getFoods();
                for (Food food : roomFoods) {
                    addFood(food);
                    System.out.println("collected " + food);
                }
                roomFoods.clear();
            } else {
                return;
            }

        }
    }
}


