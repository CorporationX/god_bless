package school.faang.sprint1.task_48627;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Getter
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    @Setter
    private CountDownLatch cdl;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        createRoom();
    }

    public void createRoom() {
        for (int i = 0; i < 7; i++) {
            rooms.add(new Room(200 + i));

        }
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
        collectedFood.addAll(room.collectedFood());
        log.info(Thread.currentThread().getName() + " собрал еду из комнаты № " + room.getNumberRoom());
        cdl.countDown();
    }

    public int sizeRooms() {
        return rooms.size();
    }
}
