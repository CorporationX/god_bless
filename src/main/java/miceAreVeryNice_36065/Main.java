package miceAreVeryNice_36065;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_POOL_SIZE = 5;
    private final static int DELAY_TIME = 0;
    private final static int PERIOD_TIME = 5;
    private final static int WAITE_TIME = 10;

    public static void main(String[] args) {
        House house = new House(
                Arrays.asList(
                        new Room("кухня", Arrays.asList(new Food("мясо"), new Food("сыр"),
                                new Food("яблоко"), new Food("семечки"))),
                        new Room("зал", Arrays.asList(new Food("мясо"), new Food("сыр"),
                                new Food("яблоко"), new Food("семечки"))),
                        new Room("кабинет", Arrays.asList(new Food("мясо"), new Food("сыр"),
                                new Food("яблоко"), new Food("семечки"))),
                        new Room("туалет", Arrays.asList(new Food("мясо"), new Food("сыр"),
                                new Food("яблоко"), new Food("семечки"))),
                        new Room("балкон", Arrays.asList(new Food("мясо"), new Food("сыр"),
                                new Food("яблоко"), new Food("семечки")))
                )
        );

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, DELAY_TIME, PERIOD_TIME, TimeUnit.SECONDS);

        executor.schedule(() -> {
            executor.shutdown();
            if (house.isEmptyAllRooms()) {
                System.out.println("Еда в дома собрана " + house.getCollectedFoods());
            } else {
                System.out.println("Что успели собрать в доме: " + house.getCollectedFoods());
            }
        }, WAITE_TIME, TimeUnit.SECONDS);
    }
}
