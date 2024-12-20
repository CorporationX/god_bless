package school.faang.task_48885.entity;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class House {
    private static final Random rand = new Random();
    private static final Lock lock = new ReentrantLock();
    private static final List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());
    private static final Logger log = LoggerFactory.getLogger(House.class);

    public void collectFood(List<Room> rooms) {


        lock.lock();
        List<Room> availableRooms = rooms.stream().filter(Room::isAvailable).toList();
        if (availableRooms.size() < 2) {
            System.out.println("All rooms are clear!");
            lock.unlock();
            return;
        }

        Room room1;
        Room room2;
        room1 = availableRooms.get(rand.nextInt(availableRooms.size()));
        do {
            room2 = availableRooms.get(rand.nextInt(availableRooms.size()));
        } while (room2 == room1);
        lock.unlock();

        room1.startCleaning();
        clearedRoom(room1);
        room1.finishCleared();

        room2.startCleaning();
        clearedRoom(room2);
        room2.finishCleared();

    }

    private static void clearedRoom(Room room) {
        collectedFood.addAll(room.getFoodList());
        log.info("Collected food: {} from {}", collectedFood, room);
        room.getFoodList().clear();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public List<Food> getCollectedFood() {
        return collectedFood;
    }
}
