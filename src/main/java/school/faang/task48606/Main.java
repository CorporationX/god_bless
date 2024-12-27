package school.faang.task48606;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final long INITIAL_DELAY = 0;
    private static final long PERIOD = 30;
    private static final int WAIT_MS = 250;
    private static final int TIMEOUT = 20;

    public static void main(String[] args) {
        Room room1 = new Room("room1");
        room1.addFood(new Food("Cola"));
        room1.addFood(new Food("Pepsi"));
        House house = new House();
        house.addRoom(room1);

        Room room2 = new Room("room2");
        room2.addFood(new Food("Pie"));
        room2.addFood(new Food("Cookies"));
        house.addRoom(room2);

        Room room3 = new Room("room3");
        room3.addFood(new Food("Lemon"));
        room3.addFood(new Food("Banana"));
        house.addRoom(room3);

        Room room4 = new Room("room4");
        room4.addFood(new Food("Bread"));
        room4.addFood(new Food("Eggs"));
        house.addRoom(room4);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleWithFixedDelay(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

        while (!house.allFoodCollected()) {
            try {
                synchronized (house) {
                    house.wait(WAIT_MS);
                }
            } catch (InterruptedException e) {
                log.error("Поток {} прерван", Thread.currentThread().getName());
            }
        }

        executor.shutdown();
        log.info("Еда в доме собрана!");

        try {
            if (executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Все задачи завершены");
            } else {
                log.error("Задачи не завершились за 20 секунд, принудительно останавливаем программу");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток main был прерван");
            executor.shutdownNow();
        }
    }
}