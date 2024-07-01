package faang.school.godbless.sprint2.mice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Getter
@AllArgsConstructor
@Slf4j
public class Main {
    private static final int POOL_SIZE = 5;
    private static final int DELAY_INTERVAL = 5;

    public static void main(String[] args) {
        House house = new House(getRooms());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        int delay = 0;

        for (int i = 0; i < getRooms().size(); i++) {
            executor.schedule(house::collectFood, delay, TimeUnit.SECONDS);
            delay += DELAY_INTERVAL;
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Еда в доме собрана: " + house.getCollectedFood());
    }

    public static List<Room> getRooms() {
        return List.of(
                new Room(1,
                        new ArrayList<>(Arrays.asList(new Food("Ананас"), new Food("Апельсин")))),
                new Room(2,
                        new ArrayList<>(Arrays.asList(new Food("Багет"), new Food("Баранина")))),
                new Room(3,
                        new ArrayList<>(Arrays.asList(new Food("Ветчина"), new Food("Вишня")))),
                new Room(4,
                        new ArrayList<>(Arrays.asList(new Food("Сыр"), new Food("Свекла")))),
                new Room(5,
                        new ArrayList<>(Arrays.asList(new Food("Картофель"), new Food("Кабачок")))),
                new Room(6,
                        new ArrayList<>(Arrays.asList(new Food("Окорок"), new Food("Окорочок")))),
                new Room(7,
                        new ArrayList<>(Arrays.asList(new Food("Хлеб"), new Food("Халва"))))
        );
    }
}
