package school.faang.sprint_3.task_48775;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {
    private House house;

    @BeforeEach
    public void setup() {
        house = new House();

        Room room1 = new Room();
        room1.addFood(new Food("Bread"));
        room1.addFood(new Food("Milk"));

        Room room2 = new Room();
        room2.addFood(new Food("Cheese"));

        Room room3 = new Room();

        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);
    }

    @Test
    public void testAddRoom() {
        assertEquals(3, house.getRooms().size(),
                "Должно быть 3 комнаты в доме");
    }

    @Test
    public void testCollectFood() {
        house.collectFood();

        List<Food> collectedFood = house.getCollectedFood();
        assertFalse(collectedFood.isEmpty(),
                "Список собранной еды не должен быть пустым");

        assertTrue(house.getRooms().stream().noneMatch(room -> room.hasFood() && collectedFood
                        .containsAll(room.getFoodList())),
                "Еда должна быть удалена из комнат, где она была собрана");
    }

    @Test
    public void testAllFoodCollected() {
        house.collectFood();
        house.collectFood();

        assertTrue(house.allFoodCollected(),
                "Все комнаты должны быть пусты после сбора всей еды");
    }

    @Test
    public void testNotEnoughRoomsForFoodCollection() {
        Room emptyRoom = new Room();
        House smallHouse = new House();
        smallHouse.addRoom(emptyRoom);

        smallHouse.collectFood();
        assertTrue(smallHouse.getCollectedFood().isEmpty(),
                "Список собранной еды должен быть пустым, так как нет еды в комнатах");
    }
}
