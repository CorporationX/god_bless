package school.faang.bjs248223.programm;

import school.faang.bjs248223.model.Food;
import school.faang.bjs248223.model.House;
import school.faang.bjs248223.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House(getTestList());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(house::collectFood, 0, 1, TimeUnit.NANOSECONDS);
    }

    private static List<Room> getTestList() {
        return List.of(
                getTestRoom(2, 1),
                getTestRoom(3, 2),
                getTestRoom(1, 3),
                getTestRoom(5, 4),
                getTestRoom(4, 5),
                getTestRoom(6, 6),
                getTestRoom(1, 7),
                getTestRoom(7, 8),
                getTestRoom(9, 9),
                getTestRoom(10, 10));
    }

    private static Room getTestRoom(int quantity, int roomNumber) {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            foods.add(new Food("Food " + i + "in Room " + roomNumber));
        }
        return new Room(foods);
    }
}

