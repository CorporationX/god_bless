package school.faang.bjs48591;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int FREQUENCY = 30;

    public static void main(String[] args) {
        var house = initHouse();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, FREQUENCY, TimeUnit.SECONDS);
        }

        while (!house.allFoodCollected()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Error while waiting all to be cleared {}", e.getMessage());
            }
        }

        executorService.shutdown();
        System.out.println(house.getCollectedFood().size());
    }

    public static House initHouse() {
        Food food1 = new Food("Apple", 80.5);
        Food food2 = new Food("Banana", 89.0);
        Food food3 = new Food("Carrot", 41.0);
        Food food4 = new Food("Donut", 195.0);
        Food food5 = new Food("Egg", 155.0);
        Food food6 = new Food("Fish", 206.0);
        Food food7 = new Food("Grapes", 69.0);
        Food food8 = new Food("Hamburger", 354.0);
        Food food9 = new Food("Ice Cream", 207.0);
        Food food10 = new Food("Juice", 112.0);
        Food food11 = new Food("Kiwi", 42.0);
        Food food12 = new Food("Lemon", 29.0);
        Food food13 = new Food("Mango", 60.0);
        Food food14 = new Food("Nuts", 607.0);
        Food food15 = new Food("Orange", 47.0);
        Food food16 = new Food("Pineapple", 50.0);
        Food food17 = new Food("Quinoa", 120.0);
        Food food18 = new Food("Rice", 130.0);
        Food food19 = new Food("Strawberry", 32.0);
        Food food20 = new Food("Tomato", 18.0);
        Food food21 = new Food("Udon", 127.0);
        Food food22 = new Food("Vegetable Soup", 75.0);
        Food food23 = new Food("Watermelon", 30.0);
        Food food24 = new Food("Xigua", 30.0);
        Food food25 = new Food("Yogurt", 59.0);
        Food food26 = new Food("Zucchini", 17.0);
        Food food27 = new Food("Bread", 265.0);
        Food food28 = new Food("Cheese", 402.0);
        Food food29 = new Food("Dates", 282.0);
        Food food30 = new Food("Eggplant", 25.0);

        Room room1 = new Room(201, new ArrayList<>());
        Room room2 = new Room(202, new ArrayList<>(List.of(food1, food2, food3)));
        Room room3 = new Room(203, new ArrayList<>(List.of(food4, food5, food6, food7, food8, food9, food10)));
        Room room4 = new Room(204, new ArrayList<>(
                List.of(food11, food12, food13, food14, food15, food16, food17, food18, food19, food20)));
        Room room5 = new Room(205, new ArrayList<>(List.of(food21, food22, food23, food24)));
        Room room6 = new Room(206, new ArrayList<>(List.of(food25, food26, food27, food28, food29, food30)));

        return new House(new ArrayList<>(List.of(room1, room2, room3, room4, room5, room6)));
    }
}
