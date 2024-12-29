package school.faang.sprint_4.task_bjs250922;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class TestDataGenerator {
    public static final Random RANDOM = new Random();
    private static final int POTION_MIN_INGREDIENTS = 1;
    private static final int POTION_MAX_INGREDIENTS = 10;
    private int potionNumber = 1;

    public List<Potion> getConcurrentPotions(int capacity) {
        return IntStream.range(0, capacity)
                .mapToObj(value -> getSinglePotion())
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    public Potion getSinglePotion() {
        String name = "Potion number " + potionNumber++;
        int requiredIngredients = RANDOM.nextInt(POTION_MIN_INGREDIENTS, POTION_MAX_INGREDIENTS + 1);
        return new Potion(name, requiredIngredients);
    }
}
