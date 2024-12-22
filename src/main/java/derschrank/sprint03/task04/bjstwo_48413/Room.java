package derschrank.sprint03.task04.bjstwo_48413;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Room implements RoomInterface {
    List<Food> food;
    String number;
    ReentrantLock lock;

    public Room(String number) {
        this.number = number;
        this.food = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public void receiveFood(Food food) {
        this.food.add(food);
    }

    private void giveAwayFood(Staff staff) {
        if (!food.isEmpty()) {
            if(staff.receiveFood(food.get(0))) {
                food.remove(0);
            };
        }
    }

    @Override
    public void knockKnock(Staff staff) {
        if (lock.tryLock()) {
            giveAwayFood(staff);
            lock.unlock();
        }
    }


    @Override
    public boolean isClear() {
        return food.isEmpty();
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public int getCountOfFood() {
        return food.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Room: ").append(number).append(". ");
        result.append("Total: ").append(food.size()).append(" ").append(food);

        return result.toString();
    }
}
