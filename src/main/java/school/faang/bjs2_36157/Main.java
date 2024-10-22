package school.faang.bjs2_36157;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();

        List<Food> foodsForRoom1 = new ArrayList<>();

        foodsForRoom1.add(new Food("Pizza"));
        foodsForRoom1.add(new Food("Cucumber"));
        foodsForRoom1.add(new Food("Tomato"));

        List<Food> foodsForRoom2 = new ArrayList<>();

        foodsForRoom2.add(new Food("Groats"));
        foodsForRoom2.add(new Food("Broccoli"));

        List<Food> foodsForRoom3 = new ArrayList<>();
        foodsForRoom3.add(new Food("Fish"));
        foodsForRoom3.add(new Food("Jelly"));

        List<Food> foodsForRoom4 = new ArrayList<>();
        foodsForRoom4.add(new Food("Peanut butter"));
        foodsForRoom4.add(new Food("Marmalade"));

        rooms.add(new Room(foodsForRoom1));
        rooms.add(new Room(foodsForRoom2));
        rooms.add(new Room(foodsForRoom3));
        rooms.add(new Room(foodsForRoom4));

        House house = new House();
        house.addRooms(rooms);

        FoodCollector foodCollector = new FoodCollector(house);
        foodCollector.executeCollectFood();
    }
}
