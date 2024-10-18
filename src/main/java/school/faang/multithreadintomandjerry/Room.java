package school.faang.multithreadintomandjerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    @Getter
    private final String name;
    private final List<Food> foods = new ArrayList<>();
    private final ReentrantLock lock;

    public Room(String name) {
        this.name = name;
        lock = new ReentrantLock();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    public void removeAllFoods() {
        foods.clear();
    }

    public boolean hasFood() {
        return foods.size() > 0;
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }
}
