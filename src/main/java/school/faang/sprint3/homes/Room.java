package school.faang.sprint3.homes;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
@Getter
@Slf4j
public class Room {
    private List<Food> foods;
    private final int number;
    private ReentrantLock lock;

    public Room(int number) {
        foods = new ArrayList<>();
        lock = new ReentrantLock();
        this.number = number;
        addFood();
    }

    public void addFood() {
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("Food" + i));
        }
    }

    public List<Food> getFoods() {
        List<Food> list = new ArrayList<>(foods);
        foods.clear();
        return list;
    }

    public boolean isClear() {
        return  foods.isEmpty();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unLock(){
        lock.unlock();
    }

}
