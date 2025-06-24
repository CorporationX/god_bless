package school.faang.miceverynice;

import static school.faang.miceverynice.FoodType.APPLE;
import static school.faang.miceverynice.FoodType.AVOCADO;
import static school.faang.miceverynice.FoodType.BANANA;
import static school.faang.miceverynice.FoodType.CABBAGE;
import static school.faang.miceverynice.FoodType.CHERRY;
import static school.faang.miceverynice.FoodType.GRAPE;
import static school.faang.miceverynice.FoodType.GREENS;
import static school.faang.miceverynice.FoodType.ORANGE;
import static school.faang.miceverynice.FoodType.PEAR;
import static school.faang.miceverynice.FoodType.PINEAPPLE;
import static school.faang.miceverynice.FoodType.RADISH;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
public record Food(String name) {

    public static Food avocado() {
        return new Food(AVOCADO.getName());
    }

    public static Food apple() {
        return new Food(APPLE.getName());
    }

    public static Food orange() {
        return new Food(ORANGE.getName());
    }

    public static Food pear() {
        return new Food(PEAR.getName());
    }

    public static Food banana() {
        return new Food(BANANA.getName());
    }

    public static Food pineapple() {
        return new Food(PINEAPPLE.getName());
    }

    public static Food greens() {
        return new Food(GREENS.getName());
    }

    public static Food cabbage() {
        return new Food(CABBAGE.getName());
    }

    public static Food cherry() {
        return new Food(CHERRY.getName());
    }

    public static Food grape() {
        return new Food(GRAPE.getName());
    }

    public static Food radish() {
        return new Food(RADISH.getName());
    }
}
