package school.faang.moduleone.sprintthree.task_43556;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class House {
    private final int roomsCount;
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private final Random random = new Random();
    private final int countOfRoomsForCleaningPerThread = 2;
    private final CountDownLatch countDownLatch;

    public House(int roomsCount, CountDownLatch cdl) {
        this.roomsCount = roomsCount;
        this.countDownLatch = cdl;
        this.rooms = new ArrayList<>(roomsCount);
        this.collectedFood = new ArrayList<>();
        createRooms(roomsCount);
    }

    private void createRooms(int roomsCount) {
        for (int i = 0; i < roomsCount; i++) {
            rooms.add(new Room(i + 1));
        }
    }

    public void collectFood() {
        for (int i = 0; i < countOfRoomsForCleaningPerThread; i++) {
            synchronized (rooms) {
                while (isFoodPresentInAnyRoom()) {
                    int roomIndex = getRandomRoomIndex();
                    Room room = rooms.get(roomIndex);
                    if (room.hasFood()) {
                        getFoodFromRoom(room);
                        break;
                    }
                }
            }
        }
    }

    private boolean isFoodPresentInAnyRoom() {
        return rooms.stream()
                .anyMatch(Room::hasFood);
    }

    private void getFoodFromRoom(Room room) {
        List<Food> foods = room.collectFood();
        collectedFood.addAll(foods);
        countDownLatch.countDown();
        log.info("{} собрал еду из комнаты {}", Thread.currentThread().getName(), room.getRoomNumber());
    }

    private int getRandomRoomIndex() {
        return random.nextInt(roomsCount);
    }
}
