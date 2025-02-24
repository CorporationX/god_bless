package school.faang.sprint1.task_48627;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Room {
    private final List<Food> foods;
    private final int numberRoom;
    private ReentrantLock lock;

    public Room(int numberRoom) {
        foods = new ArrayList<>();
        this.numberRoom = numberRoom;
        lock = new ReentrantLock();
        createList();
    }

    private void createList() {
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("food" + i));
        }
    }

    public List<Food> collectedFood() {
        List<Food> list = new ArrayList<>(foods);
        foods.clear();
        lock = new ReentrantLock();
        return list;
    }

    public boolean isClear() {
        return foods.isEmpty();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }
}
