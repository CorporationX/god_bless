package school.faang.task_48713;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Room {
    private static final int FOOD_PER_ROOM = 3;


    private final List<Food> foods;
    private final String room;
    private final Lock lock = new ReentrantLock();


    public Room(String room) {
        foods = new ArrayList<>();
        this.room = room;
        createList();
    }

    public void createList() {
        for (int i = 0; i < FOOD_PER_ROOM; i++) {
            foods.add(new Food("food" + i));
        }
    }

    public List<Food> collectFood() {
        List<Food> list = new ArrayList<>(foods);
        foods.clear();
        return list;
    }

    public boolean isClear() {
        return foods.isEmpty();
    }
}
