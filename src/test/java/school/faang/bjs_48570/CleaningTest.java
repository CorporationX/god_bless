package school.faang.bjs_48570;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CleaningTest {

    @Test
    void clean() {
        List<Room> rooms = List.of(
                new Room("Kitchen"),
                new Room("Hall"),
                new Room("Living room"),
                new Room("Bathroom "),
                new Room("Bedroom")
        );
        List<Food> foodList = List.of(
                new Food("Bacon"),
                new Food("Pasta"),
                new Food("Chocolate"),
                new Food("Cake"),
                new Food("Pizza"),
                new Food("Burger"),
                new Food("Chicken")
        );
        rooms
                .forEach(room -> foodList
                        .forEach(room::addFood));

        House house = new House(rooms);
        Cleaning cleaning = new Cleaning(house);
        cleaning.clean();

        List<Food> expected = new ArrayList<>();
        expected.addAll(foodList);
        expected.addAll(foodList);
        expected.addAll(foodList);
        expected.addAll(foodList);
        expected.addAll(foodList);

        List<Food> actual = house.getCollectedFood();
        Assertions.assertTrue(actual.containsAll(expected));
        Assertions.assertTrue(expected.containsAll(actual));
    }
}