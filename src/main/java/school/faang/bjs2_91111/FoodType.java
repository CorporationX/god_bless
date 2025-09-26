package school.faang.bjs2_91111;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FoodType {
    PIZZA("пиццы"),
    BURGER("бургеров"),
    TACO("тако"),
    CHICKEN_WINGS("куриных крылышек"),
    HOT_DOG("хот-догов");

    private final String russianName;
}