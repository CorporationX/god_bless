package school.faang.synchronization.bjs2_73462;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static school.faang.synchronization.bjs2_73462.TestData.ROOMS_WITH_FOOD;

@Slf4j
public class House {
    private final Object roomLock = new Object();
    private final Object foodLock = new Object();
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) {
        House house = new House(ROOMS_WITH_FOOD);

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
            log.info("Thread interrupted!!");
            Thread.currentThread().interrupt();
        }
    }

    public void collectFood() {
        log.info("Список комнат {}", rooms);
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

        List<Food> pickedFood = new ArrayList<>();
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
}
