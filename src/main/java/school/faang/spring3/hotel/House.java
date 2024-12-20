package school.faang.spring3.hotel;

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

    public void collectFood() {
        for (int i = 0; i < 2; i++) { // потому что две комнаты за раз
            for (Room room : rooms) {
                // synchronized (room) { // блокируем комнату, но не очень хороший вариант
                // так как другие потоки будут ждать чтоб проверить эту комнату, сделаю лучше локи
                if (room.tryLock()) {
                    if (!room.isClear()) {
                        getFoodFromRoom(room);
                        break;
                    }
                    room.unlock();
                }
                // }
            }
        }
    }

    private void getFoodFromRoom(Room room) {
        collectedFood.addAll(room.collectFood());
        log.info(Thread.currentThread().getName() + " собрал еду из комнаты " + room.getNumber());
        cdl.countDown();
    }

    private void createRooms() {
        for (int i = 1; i < 9; i++) {
            rooms.add(new Room(200 + i));
        }
    }

    public int getRoomSize() {
        return rooms.size();
    }
}
