package school.faang.bjs248999;

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
        this.number = number;
        this.foods = new ArrayList<>();
        lock = new ReentrantLock();
        fillFoods();
    }

    private void fillFoods() {
        IntStream.range(0, 6)
                .forEach(num -> foods.add(new Food("food" + num)));
    }

    public boolean isClear() {
        return foods.isEmpty();
    }

    public List<Food> collectFood() {
        List<Food> listFoods = new ArrayList<>(foods);
        foods.clear();
        return listFoods;
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unLock() {
        lock.unlock();
    }

}
