package school.faang.mice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

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
        IntStream.range(0, 10).forEach(i -> rooms.add(new Room(i, foods)));

        House house = new House(rooms);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        executor.scheduleAtFixedRate(() -> {
            if (house.isClear()) {
                log.info("Останавливаем пул");
                terminatedExecutor(executor);
            } else {
                house.collectFood();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    public static void terminatedExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Потоки принудительно прерваны по истечению времени");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}