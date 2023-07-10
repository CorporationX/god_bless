package faang.school.godbless.miceNice;

import java.util.*;
import java.util.Random;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Object lock = new Object();

    public List<Room> getRooms() {
        return rooms;
    }

    public void collectFood(Room room) {
        synchronized (lock) {
            List<Food> foodList = room.getFoodList();
            int roomId = rooms.indexOf(room);
            int threadId = (int) Thread.currentThread().getId();

            System.out.println(threadId + " поток собрал еду в " + roomId + " комнате");

            collectedFood.addAll(foodList);
            foodList.clear();
        }
    }

    public void collectFoodFromTwoRooms(Room room1, Room room2) {
        synchronized (lock) {
            collectFood(room1);
            collectFood(room2);
        }
    }

    public void initialize() {
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            Room room = new Room();

            int foodCount = random.nextInt(5) + 1;
            for (int j = 0; j < foodCount; j++) {
                Food food = new Food("Еда " + (j + 1));
                room.getFoodList().add(food);
            }

            rooms.add(room);
        }
    }

}
