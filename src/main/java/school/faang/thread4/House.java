package school.faang.thread4;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Data
public class House implements Runnable {
    private List<Room> roomList = new ArrayList<>();
    volatile private List<Food> collectedFoodList = new ArrayList<>();
    Lock lock = new ReentrantLock();

    public List<Food> collectFood() {
        Random randomRoom = new Random();
        for (int i = 0; i < 2; i++) {
            int roomNumber = randomRoom.nextInt(0, 5);
            System.out.println("Collecting food from the room: " + roomNumber);
            synchronized (lock) {
                roomList.get(roomNumber).getFoodList().stream().peek(food -> collectedFoodList.add(food)).toList();
            }
            roomList.get(roomNumber).getFoodList().clear();
            System.out.println("The remaining food in the room: " + roomList.get(roomNumber) + roomList.get(roomNumber).getFoodList());
        }

        return collectedFoodList;
    }

    @Override
    public void run() {
        collectFood();
    }

}
