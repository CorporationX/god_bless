package school.faang.task_48303;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

@Getter
public class Room {
    private final List<Food> foods;
    private final int number;
    private final ReentrantLock lock;

    public Room(int number) {
        this.foods = new ArrayList<>();
        this.number = number;
        this.lock = new ReentrantLock();
        createList();
    }

    public void createList() {
        IntStream.range(0, 5)
                .mapToObj(i -> new Food("food " + i))
                .forEach(foods::add);
    }

    public List<Food> collectFood() {
        lock.lock();
        try {
            List<Food> list = new ArrayList<>(foods);
            foods.clear();
            return list;
        } finally {
            lock.unlock();
        }
    }

    public boolean isClear() {
        lock.lock();
        try {
            return foods.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}