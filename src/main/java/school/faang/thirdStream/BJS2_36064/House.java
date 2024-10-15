package school.faang.thirdStream.BJS2_36064;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

@Data
@Slf4j
public class House {
    private static final int NUMBER_OF_ROOMS = 8;
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private CountDownLatch countDownLatch;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        createRooms();
    }

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            for (Room room : rooms) {
                if (room.tryLock()) {
                    if (!room.isClear()) {
                        getFoodFromRoom(room);
                        break;
                    }
                    room.unlock();
                }
            }
        }
    }

    private void getFoodFromRoom(Room room) {
        List<Food> newFoods = room.collectFood();

        log.info("{} собрал еду {} из {} комнаты", Thread.currentThread().getName(),
                newFoods.stream()
                        .map(Food::getFoodDescription)
                        .collect(Collectors.joining(", ")),
                room.getRoomNumber());

        collectedFood.addAll(newFoods);

        countDownLatch.countDown();
    }

    private void createRooms() {
        for (int i = 1; i <= NUMBER_OF_ROOMS; i++) {
            rooms.add(new Room(i));
        }
    }
}
