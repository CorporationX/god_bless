package school.faang.sprint_3.task_48775;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {

    @Test
    void testFoodCreation() {
        Food food = new Food("Apple");
        assertEquals("Apple", food.name(), "Название еды должно быть 'Apple'");
    }
}
