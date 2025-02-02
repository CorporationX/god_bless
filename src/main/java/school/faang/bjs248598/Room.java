package school.faang.bjs248598;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Room {
    private final List<Food> foods;
    private final int number;
    private ReentrantLock reentrantLock;

    public Room(int number) {
        foods = new ArrayList<>();
        this.number = number;
        reentrantLock = new ReentrantLock();
        createFoods();
    }

    private void createFoods() {
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("food" + i));
        }
    }

    public List<Food> collectFood() {
        List<Food> collectFood = new ArrayList<>(foods);
        foods.clear();
        return collectFood;
    }

    public boolean isClear() {
        return foods.isEmpty();
    }

    public boolean tryLock() {
        return reentrantLock.tryLock();
    }

    public void unlock() {
        reentrantLock.unlock();
    }
}
