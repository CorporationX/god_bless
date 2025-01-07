package school.faang.sprint_3.task_43556;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 5;
    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 2;
    private static final int TIMEOUT = 5;

    private static final House house = new House();

    public static void main(String[] args) {
        initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executor.shutdown();
                System.out.println("Вся еда собрана!");
            }
        }, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static void initialize() {
        Room kitchen = new Room("Кухня", new ArrayList<>(
                List.of(new Food("Конфеты"), new Food("Сыр"), new Food("Помидоры"))));
        Room bedroom = new Room("Спальня", new ArrayList<>(
                List.of(new Food("Торт"), new Food("Лазанья"), new Food("Огурцы"))));
        Room bathroom = new Room("Ванная", new ArrayList<>(
                List.of(new Food("Орехи"), new Food("Морковь"), new Food("Оливье"))));
        Room hall = new Room("Коридор", new ArrayList<>(
                List.of(new Food("Фасоль"), new Food("Рыбка"), new Food("Капуста"))));

        house.addRoom(kitchen);
        house.addRoom(bedroom);
        house.addRoom(bathroom);
        house.addRoom(hall);
    }
}
