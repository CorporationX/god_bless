package faang.school.godbless.MiceAreVeryNice;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Food {
    private String foodDescription;

    public static List<Food> getListFood() {
        return Arrays.asList(
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food"),
                new Food("Some food")
        );
    }
}
