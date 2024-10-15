package mice_are_very_nice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    private House house;
    private final int POOL_SIZE = 5;
    ScheduledExecutorService service = Executors.newScheduledThreadPool(POOL_SIZE);

    @BeforeEach
    void setUp() {
        house = new House(
                List.of(
                        new Room(List.of(new Food("mice"), new Food("apple"), new Food("fish")))
                )
        );
    }

    @Test
    void testCollectFoodThrowsExceptionIfLessThanTwoRooms() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> house.collectFood());
        assertEquals("The house must have at least 2 rooms", exception.getMessage());
    }

    @Test
    void testCollectFoodWhenBothRoomsAreEmpty() {
        Room room1 = new Room(
                List.of(new Food("mice"), new Food("apple"), new Food("fish"))
        );
        Room room2 = new Room(
                List.of(new Food("grapes"), new Food("banana"))
        );

        room1.setFoods(List.of());
        room2.setFoods(List.of());

        house.setRooms(List.of(room1, room2));
        house.collectFood();

        assertTrue(house.getCollectedFoods().isEmpty());
    }

    @Test
    void testCollectFoodWhenBothRoomsHaveFood() {
        Room room1 = new Room(
                List.of(new Food("Apple"), new Food("Bread"))
        );
        Room room2 = new Room(
                List.of(new Food("Meat"), new Food("Fish"))
        );

        house.setRooms(List.of(room1, room2));

        house.collectFood();

        assertEquals("[Food(name=Apple), Food(name=Bread), Food(name=Meat), Food(name=Fish)]", house.getCollectedFoods().toString());

        assertTrue(room1.getFoods().isEmpty());
        assertTrue(room2.getFoods().isEmpty());
    }

    @Test
    void testCollectFoodFromOneRoomWithFood() {
        Room room1 = new Room(
                List.of(new Food("Apple"), new Food("Bread"))
        );
        Room room2 = new Room(
                List.of()
        );

        house.setRooms(List.of(room1, room2));

        house.collectFood();

        assertTrue(house.getCollectedFoods().contains(new Food("Apple")));
        assertTrue(room1.getFoods().isEmpty());
        assertTrue(room2.getFoods().isEmpty());
    }
}