package school.faang.hotel;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Room {
    private final List<Food> foods;
    private final int number;
    private ReentrantLock lock;

    public Room(int number) {
        foods = new ArrayList<>();
        this.number = number;
        lock = new ReentrantLock();
        createList();
    }

    private void createList() {
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("food " + i));
        }
    }

    public List<Food> collectFood(){
        List<Food> list = new ArrayList<>(foods);
        foods.clear();
        return list;
    }

    public boolean isClear(){
        return foods.isEmpty();
    }

    public boolean tryLock(){
        return lock.tryLock();
    }

    public void unlock(){
        lock.unlock();
    }
}
