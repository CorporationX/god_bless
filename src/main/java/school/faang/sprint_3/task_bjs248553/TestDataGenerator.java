package school.faang.sprint_3.task_bjs248553;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@UtilityClass
public class TestDataGenerator {
    private static final Random RANDOM = new Random();
    private static int startRoomNumber = 1;

    public House generateHouse(int roomCapacity, int foodCapacity) {
        List<Room> rooms = generateList(roomCapacity, () -> generateRoom(foodCapacity));
        return new House(rooms);
    }

    public Room generateRoom(int foodCapacity) {
        List<Food> foods = generateList(foodCapacity, TestDataGenerator::generateFood);
        return new Room(startRoomNumber++, foods);
    }

    public Food generateFood() {
        return Food.values()[RANDOM.nextInt(Food.values().length)];
    }

    private <T> List<T> generateList(int capacity, Supplier<T> generator) {
        List<T> list = IntStream.range(0, capacity)
                .mapToObj(i -> generator.get())
                .toList();
        return new ArrayList<>(list);
    }
}
