package school.faang.synchronization.bjs2_73462;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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
        log.info("roomsEmpty() {}", roomsEmpty());
        synchronized (roomLock) {
            if (roomsEmpty()) {
                return;
            }
            roomList = roomIndexes.stream()
                    .map(rooms::get)
                    .toList();
        }
        roomList.forEach(room -> {
            pickedFood.addAll(room.pickFood());
            log.info("pickedFood - {}", pickedFood);
        });
        synchronized (foodLock) {
            collectedFood.addAll(pickedFood);
        }
        log.info("collected food size: {}", collectedFood.size());
    }

    private List<Integer> generateRooms() {
        int roomInd1 = ThreadLocalRandom.current().nextInt(0, rooms.size());
        int roomInd2 = ThreadLocalRandom.current().nextInt(0, rooms.size());
        while (roomInd2 == roomInd1) {
            roomInd2 = ThreadLocalRandom.current().nextInt(0, rooms.size());
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
                )),
                new Room(List.of(
                        new Food("food2-1"),
                        new Food("food2-6"),
                        new Food("food2-2"),
                        new Food("food2-3"),
                        new Food("food2-4"),
                        new Food("food2-5")
                )),
                new Room(List.of(
                        new Food("food3-1"),
                        new Food("food3-6"),
                        new Food("food3-2"),
                        new Food("food3-3"),
                        new Food("food3-4"),
                        new Food("food3-5")
                )),
                new Room(List.of(
                        new Food("food4-1"),
                        new Food("food4-6"),
                        new Food("food4-2"),
                        new Food("food4-3"),
                        new Food("food4-4"),
                        new Food("food4-5")
                )), new Room(List.of(
                        new Food("food5-1"),
                        new Food("food5-6"),
                        new Food("food5-2"),
                        new Food("food5-3"),
                        new Food("food5-4"),
                        new Food("food5-5")
                )),
                new Room(List.of(
                        new Food("food6-1"),
                        new Food("food6-6"),
                        new Food("food6-2"),
                        new Food("food6-3"),
                        new Food("food6-4"),
                        new Food("food6-5")
                )),
                new Room(List.of(
                        new Food("food7-1"),
                        new Food("food7-6"),
                        new Food("food7-2"),
                        new Food("food7-3"),
                        new Food("food7-4"),
                        new Food("food7-5")
                )),
                new Room(List.of(
                        new Food("food8-1"),
                        new Food("food8-6"),
                        new Food("food8-2"),
                        new Food("food8-3"),
                        new Food("food8-4"),
                        new Food("food8-5")
                )), new Room(List.of(
                        new Food("food9-1"),
                        new Food("food9-6"),
                        new Food("food9-2"),
                        new Food("food9-3"),
                        new Food("food9-4"),
                        new Food("food9-5")
                )),
                new Room(List.of(
                        new Food("food10-1"),
                        new Food("food10-6"),
                        new Food("food10-2"),
                        new Food("food10-3"),
                        new Food("food10-4"),
                        new Food("food10-5")
                )),
                new Room(List.of(
                        new Food("food11-1"),
                        new Food("food11-6"),
                        new Food("food11-2"),
                        new Food("food11-3"),
                        new Food("food11-4"),
                        new Food("food11-5")
                )),
                new Room(List.of(
                        new Food("food12-1"),
                        new Food("food12-6"),
                        new Food("food12-2"),
                        new Food("food12-3"),
                        new Food("food12-4"),
                        new Food("food12-5")
                )), new Room(List.of(
                        new Food("food13-1"),
                        new Food("food13-6"),
                        new Food("food13-2"),
                        new Food("food13-3"),
                        new Food("food13-4"),
                        new Food("food13-5")
                )),
                new Room(List.of(
                        new Food("food14-1"),
                        new Food("food14-6"),
                        new Food("food14-2"),
                        new Food("food14-3"),
                        new Food("food14-4"),
                        new Food("food14-5")
                )),
                new Room(List.of(
                        new Food("food15-1"),
                        new Food("food15-6"),
                        new Food("food15-2"),
                        new Food("food15-3"),
                        new Food("food15-4"),
                        new Food("food15-5")
                )),
                new Room(List.of(
                        new Food("food16-1"),
                        new Food("food16-6"),
                        new Food("food16-2"),
                        new Food("food16-3"),
                        new Food("food16-4"),
                        new Food("food16-5")
                ))
        )
        );

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        threadPool.scheduleAtFixedRate(house::collectFood, 0, 2, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(house::collectFood, 1, 2, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(house::collectFood, 0, 2, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(house::collectFood, 1, 2, TimeUnit.SECONDS);

        threadPool.scheduleAtFixedRate(() -> {
            if (house.roomsEmpty()) {
                threadPool.shutdown();
            }
        }, 10, 2, TimeUnit.SECONDS);


        try {
            if (!threadPool.awaitTermination(3, TimeUnit.MINUTES)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
