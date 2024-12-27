package school.faang.bjs_50843;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class PotionGatheringTest {

    @Test
    void gatherAllIngredients() {
        PotionGathering potionGathering = new PotionGathering();

        List<Potion> potionsList = IntStream.range(0, 1000)
                .boxed()
                .map(i -> new Potion("Position %d".formatted(i), i % 20))
                .toList();

        int actual = potionGathering.gatherAllIngredients(potionsList);
        int expected = 9500;

        Assertions.assertEquals(expected, actual);
    }
}