package school.faang.task_48576;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class House {

    private static final int SIMPLE_SIZE = 2;
    private static final int THREAD_POOL_SIZE = 5;
    private static final List<Food> COLLECTED_FOOD_LIST = new ArrayList<>();

    private static final List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.initializeRooms();

        ExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        for (int i = 1; i < THREAD_POOL_SIZE; i++) {
            executorService.execute(House::collectFood);
            Thread.sleep(3000);
        }
        executorService.shutdown();

        System.out.println("Еда в доме собрана");

    }

    public static void collectFood() {
        List<Room> randomRooms = collectFoodFromRandomRooms();

        for (Room room : randomRooms) {
            if (room.getFoods() != null && !room.getFoods().isEmpty()) {
                COLLECTED_FOOD_LIST.addAll(room.getFoods());
                removeFoodFromRoom(room);

            } else {
                log.info("В комнате нет еды.");
            }
        }
    }

    private static List<Room> collectFoodFromRandomRooms() {
        Random random = new Random();
        return random.ints(0, rooms.size())
                .limit(SIMPLE_SIZE)
                .mapToObj(rooms::get)
                .collect(Collectors.toList());
    }

    private static void removeFoodFromRoom(Room room) {
        room.getFoods().clear();
        System.out.println("Еда в комнате собрана");
    }

    private void initializeRooms() {
        Room room1 = new Room();
        room1.getFoods().add(new Food("Яблоко"));
        room1.getFoods().add(new Food("Банан"));
        room1.getFoods().add(new Food("Апельсин"));

        Room room2 = new Room();
        room2.getFoods().add(new Food("Груша"));
        room2.getFoods().add(new Food("Киви"));

        Room room3 = new Room();
        room3.getFoods().add(new Food("Виноград"));
        room3.getFoods().add(new Food("Персик"));

        Room room4 = new Room();
        room4.getFoods().add(new Food("Манго"));

        Room room5 = new Room();
        room5.getFoods().add(new Food("Авокадо"));
        room5.getFoods().add(new Food("Лимон"));

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
    }

}
