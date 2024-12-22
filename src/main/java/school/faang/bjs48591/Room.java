package school.faang.bjs48591;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    @Getter
    private final int number;
    private final List<Food> foodList;
    private final ReentrantLock roomLock;

    public Room(int number, List<Food> foodList) {
        this.number = number;
        this.foodList = foodList;
        this.roomLock = new ReentrantLock();
    }

    public List<Food> getFoodList() {
        return List.copyOf(foodList);
    }

    public void clearRoom() {
        foodList.clear();
    }

    public boolean tryLock() {
        return roomLock.tryLock();
    }

    public void unlock() {
        roomLock.unlock();
    }
}
