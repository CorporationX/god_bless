package school.faang.bjs2_73528;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 6;

    public static void main(String[] args) {
        House house = generateTestData();
        HouseService houseService = new HouseService(house);
        ScheduledExecutorService poolThreads = Executors.newScheduledThreadPool(NUM_THREADS);

        poolThreads.scheduleAtFixedRate(houseService::collectFood, 0, 30, SECONDS);

    }

    private static House generateTestData() {
        Food apple = new Food("Apple");
        Food bread = new Food("Bread");
        Food cheese = new Food("Cheese");
        Food milk = new Food("Milk");

        Room kitchen = new Room(List.of(apple, bread));
        Room pantry = new Room(List.of(cheese, milk));
        Room emptyRoom = new Room(List.of());

        return new House("MyHouse", List.of(kitchen, pantry, emptyRoom));
    }
}
