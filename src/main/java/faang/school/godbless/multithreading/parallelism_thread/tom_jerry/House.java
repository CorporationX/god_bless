package faang.school.godbless.multithreading.parallelism_thread.tom_jerry;

import java.util.ArrayList;
import java.util.List;

public class House {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Food> foods = new ArrayList<>();

    public void collectFood() {
        rooms.forEach(room -> {
            try {
                foods.add(room.getFood());
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        });
    }

    public void initialize() {
        Room room1 = new Room();
        room1.addFood(new Food("Apple"));
        room1.addFood(new Food("Banana"));
        room1.addFood(new Food("Chicken wings"));
        room1.addFood(new Food("Hot dog"));

        Room room2 = new Room();
        room2.addFood(new Food("Orange"));
        room2.addFood(new Food("Grapes"));
        room1.addFood(new Food("Pizza"));

        rooms.add(room1);
        rooms.add(room2);
    }

    public List<Food> getFoods() {
        return foods;
    }
}
