package school.faang.task_48716;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    private final List<Food> foods;
    @Getter
    private final int namber;
    private ReentrantLock lock;

    public Room(int number) {
        foods = new ArrayList<Food>();
        lock = new ReentrantLock();
        createList();
        this.namber = number;
    }

    private void createList() {
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("food" + i));
        }
    }

    public List<Food> collectFoods() {
        List<Food> list = new ArrayList<>(foods);
        foods.clear();
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
