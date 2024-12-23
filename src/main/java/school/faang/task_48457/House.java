package school.faang.task_48457;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Getter
@Setter
public class House {
    private List<Food> collectedFood;
    private List<Room> rooms;
    private CountDownLatch cdl;

    public House() {
        this.collectedFood = new ArrayList<>();
        this.rooms = new ArrayList<>();
        createRooms();
    }

    private void createRooms() {
        for (int i = 1; i < 10; i++) {
            rooms.add(new Room(100 + i));
        }
    }

    public int getRoomCount() {
        return rooms.size();
    }

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            for (Room room : rooms) {
                if (room.tryLock()) {
                    if (room.hasFood()) {
                        collectedFood.addAll(room.collectFood());
                        log.info("Поток {} собрал еду из комнаты {}",
                                Thread.currentThread().getName(), room.getNumber());
                        cdl.countDown();
                        break;
                    }
                    room.unlock();
                }
            }
        }
    }
}
