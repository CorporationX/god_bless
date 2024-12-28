package school.faang.task_48716;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class House {
    private final List<Room> rooms;
    private final List<Food> collectFoods;
    private CountDownLatch cdl;

    public House() {
        rooms = new ArrayList<>();
        collectFoods = new ArrayList<>();

        creatRooms();
    }

    private void creatRooms() {
        for (int i = 1; i <= 8; i++) {
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
        collectFoods.addAll(room.collectFoods());
        System.out.println(Thread.currentThread().getName() + " собрал еду из " + room.getNamber() + " комнаты");
        cdl.countDown();
    }


    public int sizeRooms() {
        return rooms.size();
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }
}
