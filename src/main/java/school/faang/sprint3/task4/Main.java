package school.faang.sprint3.task4;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int ROOMS_NUM = 10;

    private static final int THREADS_NUM = 2;

    private static final int THREADS_DELAY = 0;
    private static final int THREAD_PERIOD = 3;


    public static void main(String[] args) {
        House house = new House();

        for (int i = 0; i < ROOMS_NUM; i++) {
            Room room = new Room();
            room.food.add(new Food("apple"));
            room.food.add(new Food("banana"));
            room.food.add(new Food("orange"));
            house.rooms.add(room);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREADS_NUM);
        CountDownLatch latch = new CountDownLatch(THREADS_NUM);


        for (int i = 0; i < THREADS_NUM; i++) {
            executor.scheduleAtFixedRate(() -> {
                List<String> collectedFood = house.collectFood()
                        .stream()
                        .map(Food::getName)
                        .toList();
                System.out.println("Food collected from two rooms: " + collectedFood);
                latch.countDown();
            }, THREADS_DELAY, THREAD_PERIOD, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Еда в доме собрана!");
    }
}
