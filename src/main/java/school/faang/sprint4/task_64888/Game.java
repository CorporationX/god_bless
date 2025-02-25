package school.faang.sprint4.task_64888;

import java.util.Map;

public class Game {
    public static void main(String[] args) {
        Person dovakin = new Person("Dovakin");
        Potion potion = new Potion("Restore Health",
                new Recipe(Map.of(Ingredient.BLUE_MOUNTAIN_FLOWER, 2, Ingredient.BUTTERFLY_WING, 3)));

        dovakin.brew(potion);
    }
}
