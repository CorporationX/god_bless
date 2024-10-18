package school.faang.multithreadintomandjerry;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class House {
    public static final int QUANTITY_ROOMS = 8;
    private static final int QUANTITY_ROOMS_SELECTED = 2;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFoods = new ArrayList<>();

    CountDownLatch cdl;

    public House(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void collectFood() {
        List<Room> selectedRooms = selectRooms();
        for (Room selectedRoom : selectedRooms) {
            if (selectedRoom.tryLock()) {
                if (selectedRoom.hasFood()) {
                    getFoods(selectedRoom);
                    selectedRoom.removeAllFoods();
                    cdl.countDown();
                }
                selectedRoom.unlock();
            }
        }
    }

    private void getFoods(Room room) {
        collectedFoods.addAll(room.getFoods());
        log.info("{} collected from room: {}, foods: {}", Thread.currentThread().getName(), room.getName(), room.getFoods().size());
    }

    public void init() {
        for (int i = 0; i < QUANTITY_ROOMS; i++) {
            addRoom(generateFoods(i + 1));
        }
    }

    private Room generateFoods(int num) {
        Room newRoom = new Room("room " + num);
        Random random = new Random();
        for (int i = 0; i < num + 1; i++) {
            newRoom.addFood(new Food("food " + random.nextInt(100)));
        }
        return newRoom;
    }

    private List<Room> selectRooms() {
        List<Room> result = new ArrayList<>();

        if (rooms.size() == 0) {
            return result;
        }

        return rooms.stream()
                .filter(Room::hasFood)
                .limit(QUANTITY_ROOMS_SELECTED)
                .toList();
    }

    private void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Food> getCollectedFoods() {
        return collectedFoods;
    }
}
