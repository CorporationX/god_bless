package faang.school.godbless.MiceAreVeryNice;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Food {
    private String foodDescription;

    public static List<Food> getListFood() {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            foods.add(new Food("Some food"));
        }
        return foods;
    }
}
