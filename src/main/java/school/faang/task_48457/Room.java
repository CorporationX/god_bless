package school.faang.task_48457;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@ToString
@Getter
public class Room {
    private final List<Food> foods;
    private final int number;
    private final ReentrantLock lock;

    public Room(int number) {
        this.foods = new ArrayList<>();
        this.number = number;
        this.lock = new ReentrantLock();
        createFoods();
    }

    private void createFoods() {
        for (int i = 0; i < 10; i++) {
            foods.add(new Food("food " + i));
        }
    }

    public boolean hasFood() {
        return !(foods == null) && !foods.isEmpty();
    }

    public List<Food> collectFood() {
        List<Food> collectedFoods = new ArrayList<>(foods);
        foods.clear();

        return collectedFoods;
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }
}
