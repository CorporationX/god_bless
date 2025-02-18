package griffinfood;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FoodType {
    PIZZA("Pizza"),
    BURGER("Burger"),
    TACO("Taco"),
    PIE("Pie"),
    ICE_CREAM("Ice cream"),
    COLA("Cola");

    private final String description;
}
