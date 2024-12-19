package school.faang.task_48243;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int DELAY = 0;
    private static final int FREQUENCY = 5;
    private static final int TIMEOUT = 60;

    public static void main(String[] args) {
        Room room1 = new Room();
        room1.addFood(new Food("Cheese"));
        room1.addFood(new Food("Bread"));

        Room room2 = new Room();
        room2.addFood(new Food("Apple"));
        room2.addFood(new Food("Banana"));

        Room room3 = new Room();
        room3.addFood(new Food("Carrot"));
        room3.addFood(new Food("Potato"));

        House house = new House();
        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);
        CountDownLatch countDownLatch = new CountDownLatch(house.getRooms().size());
        house.setCountDownLatch(countDownLatch);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, DELAY, FREQUENCY, TimeUnit.SECONDS);

        try {
            if (countDownLatch.await(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.println("Еда в доме собрана!");
            } else {
                System.out.println("Тайм-аут истек, выполнение завершено не полностью.");
            }
            executor.shutdown();
        } catch (InterruptedException e) {
            System.out.println("Произошла ошибка: " + e);
        }
    }
}
