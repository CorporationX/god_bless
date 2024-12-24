package school.faang.bjs_48570;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CleaningTest {

    @Test
    void clean() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Kitchen"));
        rooms.add(new Room("Hall"));
        rooms.add(new Room("Living room"));
        rooms.add(new Room("Bathroom "));
        rooms.add(new Room("Bedroom"));

        List<Food> foodList = List.of(
                new Food("Bacon"),
                new Food("Pasta"),
                new Food("Chocolate"),
                new Food("Cake"),
                new Food("Pizza"),
                new Food("Burger"),
                new Food("Chicken")
        );
        rooms.forEach(room -> foodList.forEach(room::addFood));

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

        Comparator<Food> comparator = Comparator.comparing(Food::getName);
        expected.sort(comparator);
        actual.sort(comparator);

        Assertions.assertEquals(expected, actual);
    }
}