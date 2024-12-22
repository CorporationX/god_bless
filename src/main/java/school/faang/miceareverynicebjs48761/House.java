package school.faang.miceareverynicebjs48761;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;
    private static final int NUMBER_ROOM = 2;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        if (rooms.size() < NUMBER_ROOM) {
            System.out.println("There are not enough rooms to collect food");
            return;
        }

        Random random = new Random();
        int roomIndex1 = random.nextInt(rooms.size());
        int roomIndex2;

        do {
            roomIndex2 = random.nextInt(rooms.size());
        } while (roomIndex1 == roomIndex2);

        Room room1 = rooms.get(roomIndex1);
        Room room2 = rooms.get(roomIndex2);

        Food foodFromRoom1 = room1.removeRandomFood();
        Food foodFromRoom2 = room2.removeRandomFood();

        if (foodFromRoom1 != null) {
            collectedFood.add(foodFromRoom1);
            System.out.println("The food: " + foodFromRoom1.getName()
                    + " has been collected from the room 1");
        }

        if (foodFromRoom2 != null) {
            collectedFood.add(foodFromRoom2);
            System.out.println("The food: " + foodFromRoom2.getName()
                    + " has been collected from the room 2");
        }
    }

    public void printCollectedFood() {
        System.out.println("Collected food: ");
        for (Food food : collectedFood) {
            System.out.println(food.getName());
        }
    }
}
