package derschrank.sprint03.task04.bjstwo_48413;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public interface RoomInterface {
    void addFood(Food food);

    List<Food> removeAllFood();

    boolean hasFood();


    String getName();

    int getCountOfFood();

    ReentrantLock getLock();
}
