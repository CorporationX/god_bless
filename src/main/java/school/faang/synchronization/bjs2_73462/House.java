package school.faang.synchronization.bjs2_73462;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class House {
    private final Object roomLock = new Object();
    private final Object foodLock = new Object();
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        log.info("Список комнат {}", rooms);
        List<Food> pickedFood = new ArrayList<>();
        List<Integer> roomIndexes = generateRooms();
        log.info("Заходим в комнаты номер: {}", roomIndexes);
        List<Room> roomList;
        synchronized (roomLock) {
            if (roomsEmpty()) {
                return;
            }
            roomList = roomIndexes.stream()
                    .map(rooms::get)
                    .toList();
        }
        log.info("roomsEmpty() {}", roomsEmpty());
        roomList.forEach(room -> {
            pickedFood.addAll(room.pickFood());
            log.info("pickedFood - {}", pickedFood);
//            room.clearRoom();
            log.info("room should be cleared from food");
        });
        synchronized (foodLock) {
            collectedFood.addAll(pickedFood);
        }
        log.info("collected food: {}", collectedFood);
    }

    private List<Integer> generateRooms() {
        int roomInd1 = ThreadLocalRandom.current().nextInt(0, rooms.size());
        int roomInd2 = ThreadLocalRandom.current().nextInt(0, rooms.size());
        if (roomInd2 == roomInd1) {
            generateRooms();
        }
        return List.of(roomInd1, roomInd2);
    }

    private boolean roomsEmpty() {
        synchronized (roomLock) {
            var isEmpty = rooms.stream()
                    .allMatch(room -> room.getFoods().isEmpty());
            log.info("isEmpty - {}", isEmpty);
            return isEmpty;
        }
    }

    /**
     * Создайте объект класса House и заполните его комнаты и еду в каждой комнате.
     * <p>
     * Создайте пул потоков на 5 потоков с помощью newScheduledThreadPool.
     * <p>
     * Для каждого потока назначьте задачу, которая будет запускать сбор еды из двух комнат с интервалом в 30 секунд c
     * помощью метода scheduleAtFixedRate
     * <p>
     * Когда все потоки завершат работу, выведите сообщение «Еда в доме собрана!».
     */
    public static void main(String[] args) {
        House house = new House(List.of(
                new Room(List.of(
                        new Food("food1-1"),
                        new Food("food1-6"),
                        new Food("food1-2"),
                        new Food("food1-3"),
                        new Food("food1-4"),
                        new Food("food1-5")
                )
                ),
                new Room(List.of(
                        new Food("food2-1"),
                        new Food("food2-6"),
                        new Food("food2-2"),
                        new Food("food2-3"),
                        new Food("food2-4"),
                        new Food("food2-5")
                )
                ),
                new Room(List.of(
                        new Food("food3-1"),
                        new Food("food3-6"),
                        new Food("food3-2"),
                        new Food("food3-3"),
                        new Food("food3-4"),
                        new Food("food3-5")
                )
                ),
                new Room(List.of(
                        new Food("food4-1"),
                        new Food("food4-6"),
                        new Food("food4-2"),
                        new Food("food4-3"),
                        new Food("food4-4"),
                        new Food("food4-5")
                )
                )
        )
        );

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        threadPool.scheduleAtFixedRate(house::collectFood, 0, 5, TimeUnit.SECONDS);

//        threadPool.shutdown();

        try {
            if (!threadPool.awaitTermination(3, TimeUnit.MINUTES)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
