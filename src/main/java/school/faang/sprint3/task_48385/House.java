package school.faang.sprint3.task_48385;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class House {
    private static final int TIME_TO_PROCESS_ROOM = 10;
    private final List<Room> roomList = Collections.synchronizedList(new ArrayList<>());
    private final AtomicInteger roomToAssignIdx = new AtomicInteger(0);
    @Getter
    private boolean allFoodCollected = false;

    public List<Food> collectFromRoom(Room room) throws InterruptedException {
        List<Food> yieldedFood = room.yieldAllFood();
        TimeUnit.SECONDS.sleep(TIME_TO_PROCESS_ROOM);
        return yieldedFood;
    }

    public synchronized Room assignRoom() {
        if (roomToAssignIdx.get() >= roomList.size()) {
            allFoodCollected = true;
            throw new IndexOutOfBoundsException("No more rooms to collect food from");
        }
        return roomList.get(roomToAssignIdx.getAndIncrement());
    }

    public void shuffleRooms() {
        Collections.shuffle(roomList);
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }
}
