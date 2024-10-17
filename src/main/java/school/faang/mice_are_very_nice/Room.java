package school.faang.mice_are_very_nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Room {
    private final List<Food> food;
    private final int number;
    private ReentrantLock lock;

    public Room(int number) {
        food = new ArrayList<>();
        this.number = number;
        lock = new ReentrantLock();
        addFood();
    }

    private void addFood() {
        for (int i = 0; i < 5; i++) {
            food.add(new Food("food" + i));
        }
    }

    public List<Food> removeAllFood() {
        List<Food> list = new ArrayList<>(food);
        food.clear();
        return list;
    }

    public boolean hasFood() {
        return !food.isEmpty();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }
}