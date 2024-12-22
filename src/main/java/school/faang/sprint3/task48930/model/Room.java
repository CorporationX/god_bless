package school.faang.sprint3.task48930.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Data
public class Room {
    private final String name;
    private List<Food> foodList;
    private ReentrantLock lock;

    public Room(String name, List<Food> foodList) {
        this.name = name;
        this.foodList = foodList;
        lock = new ReentrantLock();
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public boolean isRoomEmpty() {
        return foodList.isEmpty();
    }

    public void clearFood() {
        foodList.clear();
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }

    public static Room getRandomRoom(List<Room> rooms, Room exceptRoom) {
        Random rn = new Random();
        int maximum = rooms.size() - 1;
        int minimum = 0;
        int randomNum;
        Room randomRoom;

        do {
            randomNum = rn.nextInt(maximum - minimum + 1) + minimum;
            randomRoom = rooms.get(randomNum);
        } while (randomRoom.equals(exceptRoom));

        return randomRoom;
    }

}
