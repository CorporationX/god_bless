package faang.school.godbless.miceNice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class House {
    private final List<Room> rooms;
    private List<Food> collectedFood;
    private int completedThreads;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        completedThreads = 0;
    }


    public synchronized void collectFood() {
        for (Room room : rooms) {
            List<Food> roomFood = room.getFood();
            synchronized (roomFood) {
                collectedFood.addAll(roomFood);
                roomFood.clear();
            }
        }
        System.out.println("Collected food removed from food lists in rooms");
        completedThreads++;
        if (completedThreads == 5) {
            System.out.println("The food in the house is collected!");
        }
    }

    public void initialize() {
        Random random = new Random();
        int numRooms = random.nextInt(5) + 1;
        for (int i = 0; i < numRooms; i++) {
            Room room = new Room();
            int numFood = random.nextInt(10) + 1;
            for (int j = 0; j < numFood; j++) {
                Food food = new Food("Food" + (i * numFood + j));
                room.getFood().add(food);
            }
            rooms.add(room);
        }
        System.out.println("Room and food lists are completed");
    }

}
