package faang.school.godbless.mice_very_nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Getter
public class Room {
    private List<Food> foodsInRoom = new ArrayList<>();

    public void removeFood() {
        foodsInRoom = new ArrayList<>();
    }

    public void populateRandomFood(int maxFoodPerRoom) {
        String[] foodNames = { "Apple", "Banana", "Orange", "Grapes", "Watermelon", "Pineapple" };
        Random random = new Random();
        int numFoods = random.nextInt(maxFoodPerRoom + 1);

        for (int i = 0; i < numFoods; i++) {
            int randomIndex = random.nextInt(foodNames.length);
            String foodName = foodNames[randomIndex];
            Food food = new Food(foodName);
            foodsInRoom.add(food);
        }
    }
}
