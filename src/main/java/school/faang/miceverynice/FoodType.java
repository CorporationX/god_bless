package school.faang.miceverynice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Getter
@RequiredArgsConstructor
public enum FoodType {
    AVOCADO("Avocado"),
    APPLE("Apple"),
    ORANGE("Orange"),
    PEAR("Pear"),
    BANANA("Banana"),
    PINEAPPLE("Pineapple"),
    GREENS("Greens"),
    CABBAGE("Cabbage"),
    CHERRY("Cherry"),
    GRAPE("Grape"),
    RADISH("Radish");

    private final String name;
}
