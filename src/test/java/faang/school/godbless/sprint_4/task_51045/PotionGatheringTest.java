package faang.school.godbless.sprint_4.task_51045;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PotionGatheringTest {

    private static final Potion POTION = new Potion("Potion", 5);

    @Test
    void teatGatherIngredients() {
        assertEquals(POTION.getRequiredIngredients(), PotionGathering.gatherIngredients(POTION));
    }
}