package school.faang.task_48828;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class House {
    private final List<Room> rooms;
    @Getter
    private final List<Food> collectedFood;
    @Getter
    private boolean work;

    public House() {
        collectedFood = new ArrayList<>();
        rooms = new ArrayList<>();
        createRooms();
        work = true;
    }

    public void createRooms() {
        for (int i = 0; i < 11; i++) {
            rooms.add(new Room(300 + i));
        }
    }

    public void collectFood() {
        if (!work) {
            return;
        }
        boolean allClear = true;
        for (int i = 0; i < 2; i++) {
            for (Room room : rooms) {
                synchronized (room) {
                    if (!room.isClear()) {
                        allClear = false;
                        getFoodFromRoom(room);
                        break;
                    }
                }
            }
        }
        if (allClear) {
            work = false;
        }
    }

    private void getFoodFromRoom(Room room) {
        collectedFood.addAll(room.collectFood());
        log.info("{} collected food from {} room.", Thread.currentThread().getName(), room.getNumberOfRoom());
    }
}
