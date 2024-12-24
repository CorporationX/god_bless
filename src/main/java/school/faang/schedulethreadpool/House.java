package school.faang.schedulethreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();
    private Random random = new Random();

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }

    public boolean collectFood() {
        if (rooms.isEmpty()) {
            System.out.println("The rooms are empty of food!");
            return false;
        }
        int roomIndex1 = generateRandomNumber(rooms.size());
        int roomIndex2;
        do {
            roomIndex2 = generateRandomNumber(rooms.size());
        } while (roomIndex1 == roomIndex2);
        Room room1 = rooms.get(roomIndex1);
        Room room2 = rooms.get(roomIndex2);

        List<Food> foodToCollect = new ArrayList();
        foodToCollect.addAll(room1.getFoods());
        foodToCollect.addAll(room2.getFoods());

        room1.getFoods().clear();
        room2.getFoods().clear();

        collectedFood.addAll(foodToCollect);
        System.out.println("Collected food from two rooms: " + roomIndex1 + ", " + roomIndex2);
        return allFoodCollected();
    }

    private int generateRandomNumber(int numberOfRooms) {
        return random.nextInt(numberOfRooms);
    }
}
