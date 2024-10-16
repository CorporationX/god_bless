package school.faang.multithreading.parallelism.mice.are.very.nice;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private final static int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        Food food1 = new Food("Food1");
        Food food2 = new Food("Food2");
        Food food3 = new Food("Food3");
        Food food4 = new Food("Food4");
        Food food5 = new Food("Food5");
        Food food6 = new Food("Food6");
        Food food7 = new Food("Food7");
        Food food8 = new Food("Food8");
        Food food9 = new Food("Food9");
        Food food10 = new Food("Food10");

        Room room1 = new Room(1);
        room1.addFood(food1);
        room1.addFood(food2);

        Room room2 = new Room(2);
        room2.addFood(food3);
        room2.addFood(food4);

        Room room3 = new Room(3);
        room3.addFood(food5);
        room3.addFood(food6);

        Room room4 = new Room(4);
        room4.addFood(food7);
        room4.addFood(food8);

        Room room5 = new Room(5);
        room5.addFood(food9);
        room5.addFood(food10);

        House house = new House(Arrays.asList(room1, room2, room3, room4, room5));

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(
                () -> {
                    List<Food> foods = house.collectFood();
                    log.info("Поток: {} собрал еду: {}", Thread.currentThread().getName(), foods);
                },
                0, 30, TimeUnit.SECONDS
        );

        executor.schedule(executor::shutdown, 2, TimeUnit.MINUTES);

        if (executor.awaitTermination(3, TimeUnit.MINUTES)) {
            boolean noFoodInHouse = house.getRooms().stream()
                    .noneMatch(Room::hasFood);
            log.info("В доме {}", noFoodInHouse ? "не осталось еды" : "есть еда");
        }
    }
}
