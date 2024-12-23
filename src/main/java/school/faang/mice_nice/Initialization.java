package school.faang.mice_nice;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Initialization {
    private final Random random = new Random();

    public House createHouse() {
        List<Room> rooms = IntStream.range(0, DataSet.AMOUNT_OF_ROOMS)
                .mapToObj(number -> new Room(101 + number))
                .peek(room -> addFoodToRoom(room.getFoods()))
                .toList();
        return new House(rooms);
    }

    private void addFoodToRoom(List<Food> foods) {
        Food[] randomFoods = Food.values();
        for (int i = 0; i < DataSet.AMOUNT_OF_FOODS_IN_ROOMS; i++) {
            foods.add(randomFoods[random.nextInt(randomFoods.length)]);
        }
    }
}
