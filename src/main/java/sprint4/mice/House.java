package sprint4.mice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private static final List<Food> FOODS = List.of(
            new Food("Pear"), new Food("Milk"), new Food("Apple"), new Food("Meal"), new Food("Cucumber"),
            new Food("Cheese"), new Food("Bread"), new Food("Orange"), new Food("Ice cream"), new Food("Chocolate")
            );
    private static final Random RANDOM = new Random();
    private static final int NUM_FOODS = 5;

    private final List<Food> collectedFood = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();

    public void collectFood() {
        int roomsVisited = 0;
        for (Room room : rooms) {
            if (roomsVisited == 2) {
                break;
            }
            if (room.foods().isEmpty()) {
                continue;
            }
            collectedFood.addAll(room.foods());
            room.foods().clear();
            roomsVisited++;
        }
    }

    public void initRooms() {
        rooms.add(new Room("Living room", initFoods()));
        rooms.add(new Room("Kitchen", initFoods()));
        rooms.add(new Room("Bedroom", initFoods()));
    }

    private List<Food> initFoods() {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < NUM_FOODS; i++) {
            foods.add(FOODS.get(RANDOM.nextInt(FOODS.size())));
        }
        return foods;
    }
}
