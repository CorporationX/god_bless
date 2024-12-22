package school.faang.task48808;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;

    @Setter
    private CountDownLatch cdl;


    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        createRooms();
    }

    public void createRooms() {
        for (int i = 1; i < 9; i++) {
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
        collectedFood.addAll(room.collectFood());
        log.info("{}собрал food from {} ", Thread.currentThread().getName(), room);
        cdl.countDown();

    }

    public int sizeRoom() {
        return rooms.size();
    }
}
