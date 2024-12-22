package school.faang.sprint_3.task_48584;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final long INITIAL_DELAY = 0;
    private static final long PERIOD = 30;
    private static final int PLUG_MILLISECONDS = 1000;

    public static void main(String[] args) {
        Room room1 = new Room("room1");
        room1.addFood(new Food("Cheese"));
        room1.addFood(new Food("Bread"));
        room1.addFood(new Food("Butter"));
        room1.addFood(new Food("Milk"));
        House house = new House();
        house.addRoom(room1);

        Room room2 = new Room("room2");
        room2.addFood(new Food("Cake"));
        room2.addFood(new Food("Cookies"));
        room2.addFood(new Food("Crackers"));
        room2.addFood(new Food("Chocolate"));
        house.addRoom(room2);

        Room room3 = new Room("room3");
        room3.addFood(new Food("Orange"));
        room3.addFood(new Food("Banana"));
        room3.addFood(new Food("Apple"));
        room3.addFood(new Food("Strawberries"));
        house.addRoom(room3);

        Room room4 = new Room("room4");
        room4.addFood(new Food("Eggs"));
        room4.addFood(new Food("Sausages"));
        room4.addFood(new Food("Bacon"));
        room4.addFood(new Food("Tea"));
        house.addRoom(room4);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

        while (!house.allFoodCollected()) {
            try {
                Thread.sleep(PLUG_MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println("Поток " + Thread.currentThread().getName() + " прерван");
            }
        }

        executor.shutdown();
        System.out.println("Еда в доме собрана!");

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
