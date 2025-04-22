package school.faang.peter_griffen;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FoodType {
    PIZZA("Пицца"),
    BURGER("Бургер"),
    TACO("Тако");

    private final String displayName;
}
