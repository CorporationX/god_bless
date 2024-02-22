package faang.school.godbless.miceareverynice2949;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@ToString
public class Food {
    private String name;
    private static final String[] ITEMS = {"Bread", "Cheese", "Milk", "Cookies", "Chocolate", "Spaghetti", "Meatballs",
            "Coca-Cola", "Pancakes", "Fish", "Rice", "Pizza", "Sushi", "Salad", "Apple"};
    private static Random random = new Random();

    public Food(String name) {
        this.name = name;
    }

    public static List<Food> initializeFoodList() {
        int itemsLength = ITEMS.length;
        return new ArrayList<>(List.of(
                new Food(ITEMS[random.nextInt(itemsLength)]),
                new Food(ITEMS[random.nextInt(itemsLength)]),
                new Food(ITEMS[random.nextInt(itemsLength)])
        ));
    }
}
