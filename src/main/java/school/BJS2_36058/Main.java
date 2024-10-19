package school.BJS2_36058;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int SCHEDULED_THREADS = 5;
    private static final int NUMBER_OF_ROOMS = 8;
    private static final int NUMBER_OF_FOOD = 10;

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(NUMBER_OF_ROOMS);
        House house = new House(latch);
        initializeHouse(house);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(SCHEDULED_THREADS);
        for (int i = 0; i < SCHEDULED_THREADS; i++) {
            executorService.scheduleAtFixedRate(() -> house.collectFood(), 0, 5, TimeUnit.SECONDS);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("Еда собрана из всех комнат!");

    }

    private static void initializeHouse(House house) {
        for (int i = 1; i <= NUMBER_OF_ROOMS; i++) {
            house.getRooms().add(new Room("Номер комнаты: " + i));
        }
        for (Room room : house.getRooms()) {
            for (int i = 0; i < NUMBER_OF_FOOD; i++) {
                room.addFood(new Food("Еда номер: " + i));
            }
        }
    }
}

