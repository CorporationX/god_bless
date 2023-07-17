package faang.school.godbless.multithreading.alchemy;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlchemistTest {
    private Random random;
    private Alchemist alchemist;

    @BeforeEach
    void setUp() {
        alchemist = new Alchemist();
        random = new Random();
    }

    @Test
    void brewPotions() {
        List<Potion> potions = IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new Potion("Potion " + i, random.nextInt(3, 15)))
                .toList();

        int expected = potions.stream()
                .mapToInt(Potion::getRequiredIngredients)
                .sum();

        System.out.println(expected);
        alchemist.brewPotions(potions);
    }

    @Test
    void brewPotionsAnother() {
        List<Potion> potions = IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new Potion("Potion " + i, random.nextInt(3, 15)))
                .toList();

        int expected = potions.stream()
                .mapToInt(Potion::getRequiredIngredients)
                .sum();

        System.out.println(expected);
        alchemist.brewPotionsAnother(potions);
    }
}