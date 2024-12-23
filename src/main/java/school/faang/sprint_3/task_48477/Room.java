package school.faang.sprint_3.task_48477;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Room {
    private String name;
    private final List<Food> foodsInRoom;
    private ReentrantLock lock;

    public Room(String name) {
        this.name = name;
        foodsInRoom = new ArrayList<>();
        lock = new ReentrantLock();
    }

    public void addFood(List<Food> food) {
        foodsInRoom.addAll(food);
    }

    public List<Food> pickUpFood() {
        List<Food> foods = new ArrayList<>(foodsInRoom);
        foodsInRoom.clear();
        return foods;
    }

    public boolean allFoodTaken() {
        return foodsInRoom.isEmpty();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }
}
