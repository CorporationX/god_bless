package school.faang.hotel;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private void createRooms() {
        for (int i = 1; i < 9; i++) {
            rooms.add(new Room(200 + i));
        }
    }

    public void collectFood(){
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
        log.info("{} собрал еду из {} комнаты", Thread.currentThread().getName(), room.getNumber());
        cdl.countDown();
    }

    public int sizeRooms(){
        return rooms.size();
    }
}
