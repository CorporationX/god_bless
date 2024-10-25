package school.faang.sprint3.homes;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class House {
    private List<Room> rooms;
    private List<Thread> collectedFood;
    private CountDownLatch cdl;

    public House() {
        this.collectedFood = new ArrayList<Thread>();
        this.rooms = new ArrayList<>();
        addRoom();
    }

    public void addRoom() {
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
                    room.unLock();
                }
            }

        }
    }

    private void getFoodFromRoom(Room room) {
        collectedFood.add(Thread.currentThread());
        log.info(Thread.currentThread().getName() + " собрал еду из " + room.getNumber() + " комнаты");
        cdl.countDown();
    }

    public int sizeRoom() {
        return rooms.size();
    }
}
