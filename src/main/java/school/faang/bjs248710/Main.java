package school.faang.bjs248710;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    private static final List<String> FOODS = List.of(
            "meat",
            "cheese",
            "milk",
            "meat",
            "vegetables",
            "cat food",
            "fruits"
    );
    private static final int MAX_FOODS = 10;
    private static final int MAX_ROOMS = 10;
    private static final int POOL_SIZE = 5;
    public static final int PERIOD = 30;

    public static void main(String[] args) {
        House house = new House(generateRooms());
        house.printFoodsSizes();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);
        executorService.scheduleAtFixedRate(house::collectFood, 0, PERIOD, TimeUnit.SECONDS);
        while (true) {
            if (house.allFoodCollected()) {
                executorService.shutdown();
                System.out.println("Еда в доме собрана!");
                break;
            }
        }
        house.printFoodsSizes();
    }

    private static List<Food> generateFoods() {
        return new Random().ints(getRandomInt(MAX_FOODS), 0, FOODS.size())
                .mapToObj(i -> new Food(FOODS.get(i)))
                .toList();
    }

    private static List<Room> generateRooms() {
        return Stream.iterate(0, n -> n + 1)
                .limit(getRandomInt(MAX_ROOMS))
                .map(i -> new Room(generateFoods()))
                .toList();
    }

    private static int getRandomInt(Integer max) {
        return new Random().nextInt(max);
    }
}
