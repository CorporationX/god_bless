package school.faang.MiceAreVeryNice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class Room {
    private List<Food> foods = new ArrayList<>();

    public void addFood (Food food){
        this.getFoods().add(food);
    }

    public void addRandomFoods(List<String> foodList){
        final int FOOD_AMOUNT = 3;
        Random random = new Random();
        for (int i = 0; i < FOOD_AMOUNT; i++) {
            this.addFood(new Food(foodList.get(random.nextInt(foodList.size()))));
        }
    }

}
