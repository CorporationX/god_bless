package school.faang.thirdStream.BJS2_36064;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Room {
    private static final int NUMBER_OF_DISHES_PER_ROOM = 3;
    private final int roomNumber;
    private final List<Food> foods;
    private Faker faker = new Faker();
    private ReentrantLock lock;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        foods = new ArrayList<>();
        lock = new ReentrantLock();
        addFood();
    }

    public List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>(foods);
        foods.clear();
        return collectedFood;
    }

    public boolean isClear() {
        return foods.isEmpty();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock(){
        lock.unlock();
    }

    private void addFood() {
        for (int i = 0; i < NUMBER_OF_DISHES_PER_ROOM; i++) {
            foods.add(new Food(faker.food().dish()));
        }
    }
}
