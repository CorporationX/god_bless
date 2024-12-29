package derschrank.sprint03.task04.bjstwo_48413;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Room implements RoomInterface {
    private final String name;
    private final ReentrantLock lock;
    private List<Food> food;

    public Room(String number) {
        this.name = number;
        this.food = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public void addFood(Food food) {
        this.food.add(food);
    }

    @Override
    public List<Food> removeAllFood() {
        List<Food> foodToReturn = food;
        synchronized (this) {
            food = new ArrayList<>();
        }
        return foodToReturn;
    }

    @Override
    public synchronized boolean hasFood() {
        return !food.isEmpty();
    }

    @Override
    public synchronized int getCountOfFood() {
        return food.size();
    }

    @Override
    public ReentrantLock getLock() {
        return lock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Room: ").append(name).append(". ");
        result.append("Total: ").append(food.size()).append(" ").append(food);

        return result.toString();
    }
}
