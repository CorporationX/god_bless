package school.faang.mice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int ROOM_COUNT = 10;

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        List<Food> foods = List.of(
                new Food("Food1"),
                new Food("Food2"),
                new Food("Food3"),
                new Food("Food4"),
                new Food("Food5"),
                new Food("Food6"),
                new Food("Food7"),
                new Food("Food8"),
                new Food("Food9"),
                new Food("Food10")
        );

        IntStream.range(0, 11).forEach(
                i -> rooms.add(new Room(i, foods)));


        House house = new House(rooms);

//        for (int i = 0; i < ROOM_COUNT; i++) {
//            house.addRoom(new Room(i));
//            for (int j = 0; j < ThreadLocalRandom.current().nextInt(); j++) {
//                house.getRooms().a(new Food(String.format("Food %d.%d", i, j)));
//            }
//        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, 0, 1, TimeUnit.SECONDS);


        while (!house.checkCollectedFood()) {
            try {
                log.info("Проверка комнаты на пустоту");
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                log.info("Поток прерван");
            }
        };
        terminatedExecutor(executor);


    }

    public static void terminatedExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
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