package school.BJS2_36058;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    @Getter
    private String name;
    private List<Food> foods = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public void getFoods(List<Food> collectedFoods, CountDownLatch latch) {
        if (lock.tryLock()) {
            try {
                    foods.forEach(x -> collectedFoods.add(x));
                    foods.clear();
                    latch.countDown();
                    System.out.printf("Еда собрана из комнаты: " + name);
                    System.out.println();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Ой, комната " + name + " занята кем-то, пойду в другие места!");
        }
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
