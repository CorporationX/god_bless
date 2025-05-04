package school.faang.bjs2_73528;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int MAX_EXPECTATION = 3;
    private static final List<Food> COLLECT_FOODS = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        House house = generateTestData();
        HouseService houseService = new HouseService(house);
        ScheduledExecutorService poolThreads = Executors.newScheduledThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_THREADS).forEach(i ->
                poolThreads.scheduleAtFixedRate(() -> {
                    List<Food> foods = houseService.collectFood();
                    COLLECT_FOODS.addAll(foods);
                    if (houseService.allFoodCollected()) {
                        shutdownPool(poolThreads);
                    }
                }, i * 3L, 30, SECONDS)
        );
    }

    private static void shutdownPool(ExecutorService executorService) {
        executorService.shutdown();
        try {
            boolean isClose = executorService.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                log.error("Thread stoppage error");
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Thread stoppage error");
            executorService.shutdownNow();
        } finally {
            log.info("All the food packed {}", COLLECT_FOODS);
        }
    }

    private static House generateTestData() {
        Food apple = new Food("Apple");
        Food bread = new Food("Bread");
        Food cheese = new Food("Cheese");
        Food milk = new Food("Milk");
        Food eggs = new Food("Eggs");
        Food butter = new Food("Butter");
        Food carrots = new Food("Carrots");
        Food potatoes = new Food("Potatoes");
        Food tomatoes = new Food("Tomatoes");
        Food cucumber = new Food("Cucumber");
        Food rice = new Food("Rice");
        Food pasta = new Food("Pasta");
        Food chicken = new Food("Chicken");
        Food beef = new Food("Beef");
        Food fish = new Food("Fish");

        Room kitchen = new Room(new ArrayList<>(List.of(apple, bread, milk, butter, eggs)));
        Room pantry = new Room(new ArrayList<>(List.of(cheese, potatoes, tomatoes, cucumber)));
        Room diningRoom = new Room(new ArrayList<>(List.of(carrots, rice, pasta)));
        Room basement = new Room(new ArrayList<>(List.of(beef, chicken, fish)));
        Room storage = new Room(new ArrayList<>(List.of(cheese, butter, eggs)));
        Room emptyRoom = new Room(new ArrayList<>());
        Room livingRoom = new Room(new ArrayList<>());
        Room bedroom = new Room(new ArrayList<>());
        Room bathroom = new Room(new ArrayList<>());
        Room study = new Room(new ArrayList<>());

        return new House(
                "MyHouse",
                new ArrayList<>(
                        List.of(kitchen,
                                diningRoom,
                                livingRoom,
                                bathroom,
                                bedroom,
                                study,
                                pantry,
                                storage,
                                basement,
                                emptyRoom))
        );
    }
}
