package school.faang.mice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int ROOM_COUNT = 10;

    public static void main(String[] args) {
        House house = new House();

        for (int i = 0; i < ROOM_COUNT; i++) {
            house.addRoom(new Room(i));
            for (int j = 0; j < ThreadLocalRandom.current().nextInt(); j++) {
                house.getRooms().get(i).addFood(new Food(String.format("Food %d.%d", i, j)));
            }
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);

        while (!house.checkCollectedFood()) {
            try {
                log.info("Проверка комнаты на пустоту");
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                log.info("Поток прерван");
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Потоки принудительно прерваны по истечению времени");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        } finally {
            log.info("Основной поток закрыт");
        }
    }
}