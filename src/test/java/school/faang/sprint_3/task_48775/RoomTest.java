package school.faang.sprint_3.task_48775;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void testAddFood() {
        Room room = new Room();
        Food food = new Food("Banana");

        room.addFood(food);
        assertTrue(room.hasFood(), "Комната должна содержать еду");
    }

    @Test
    public void testClearAndGetFood() {
        Room room = new Room();
        Food food1 = new Food("Apple");
        Food food2 = new Food("Orange");
        room.addFood(food1);
        room.addFood(food2);

        List<Food> collected = room.clearAndGetFood();

        assertEquals(2, collected.size(), "Должно быть собрано 2 еды");
        assertTrue(collected.contains(food1), "Должно содержать Apple");
        assertTrue(collected.contains(food2), "Должно содержать Orange");
        assertFalse(room.hasFood(), "Комната должна быть пустой после сбора еды");
    }
}
