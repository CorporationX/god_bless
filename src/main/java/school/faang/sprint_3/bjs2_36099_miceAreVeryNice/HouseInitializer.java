package school.faang.sprint_3.bjs2_36099_miceAreVeryNice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseInitializer {
    private static final List<String> FOOD_TYPES = List.of(
            "Apple", "Banana", "Orange", "Milk", "Bread", "Eggs", "Cheese", "Tomato",
            "Potato", "Chicken", "Beef", "Rice", "Pasta", "Yogurt", "Butter", "Carrot",
            "Cucumber", "Fish", "Onion", "Garlic"
    );

    private static List<Food> getFiveRandomProducts() {
        List<String> randomFood = new ArrayList<>(FOOD_TYPES);
        Collections.shuffle(randomFood);
        List<Food> foodList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            foodList.add(new Food(randomFood.get(i)));
        }

        return foodList;
    }

    public static List<Room> getFiveRandomRooms() {
        return List.of(new Room(getFiveRandomProducts()),
                new Room(getFiveRandomProducts()),
                new Room(getFiveRandomProducts()),
                new Room(getFiveRandomProducts()),
                new Room(getFiveRandomProducts()),
                new Room(getFiveRandomProducts()));
    }
}
