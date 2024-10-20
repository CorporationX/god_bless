package tasks.bjs2_35987;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class House {
    private Random random = new Random();
    private final List<Room> rooms = generatorRooms();
    private final int THREAD_COUNT = 5;
    private final int ROOMS_PER_THREAD = 3;
    private List<Food> collectedFoods = new ArrayList<>();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        House house = new House();
        Queue<Room> queueRooms = new LinkedList<>(house.rooms);

        for (int i = 0; i < house.THREAD_COUNT; i++) {
            house.executor.scheduleAtFixedRate(() -> house.collectFood(queueRooms), 1, 3, TimeUnit.SECONDS);
        }

        try {
            if (house.executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Все продукты собраны");
            } else {
                System.out.println("Превышено время обработки задачи. Все потоки будут остановлены принудительно");
                house.executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("В процессе выполнения задачи произошла ошибка : " + e.getMessage());
            System.out.println("Все потоки будут остановлены принудительно");
            house.executor.shutdownNow();
        }
    }

    private void collectFood(Queue<Room> queueRooms) {
        String threadName = Thread.currentThread().getName();
        List<Room> rooms = getRoomsFromQueue(queueRooms);

        if (rooms.isEmpty()) {
            System.out.println(threadName + ". Нету свободных комнат");
            executor.shutdown();
            return;
        }

        rooms.forEach(room -> {
            List<Food> collecteFood = room.collectFoods();

            synchronized (collectedFoods) {
                collectedFoods.addAll(collecteFood);
            }

            System.out.println(threadName + ". Собрали еду в комнате " + room.getName());
        });
    }

    private List<Room> generatorRooms() {
        List<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Кухня_1", generatorFoods()));
        rooms.add(new Room("Кухня_2", generatorFoods()));
        rooms.add(new Room("Гостиная", generatorFoods()));
        rooms.add(new Room("Спальня_1", generatorFoods()));
        rooms.add(new Room("Спальня_2", generatorFoods()));
        rooms.add(new Room("Спальня_3", generatorFoods()));
        rooms.add(new Room("Спальня_4", generatorFoods()));
        rooms.add(new Room("Кабинет_1", generatorFoods()));
        rooms.add(new Room("Кабинет_2", generatorFoods()));

        return rooms;
    }

    private List<Food> generatorFoods() {
        List<String> FOOD_NAMES = Arrays.asList(
            "Яблоко", "Бутерброд", "Пицца", "Чай", "Кофе", "Печенье", "Сыр", "Колбаса", "Хлеб"
        );

        List<Food> foods = IntStream
            .range(0, random.nextInt(4) + 2)
            .mapToObj(i -> {
                int randomFoodIndex = random.nextInt(FOOD_NAMES.size());

                return new Food(FOOD_NAMES.get(randomFoodIndex));
            })
            .collect(Collectors.toList());

        return foods;
    }

    private List<Room> getRoomsFromQueue(Queue<Room> queueRooms) {
        synchronized (queueRooms) {
            return IntStream
                .range(0, ROOMS_PER_THREAD)
                .mapToObj(i -> queueRooms.poll())
                .filter(room -> room != null)
                .toList();
        }
    }
}
