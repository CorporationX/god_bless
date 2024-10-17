package ru.kraiush.BJS2_36122;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
    }

    public void collectFood() {
        Random random = new Random();
        int countRooms = 2;
        while (countRooms != 0 && !allFoodCollected()) {
            int randomRoom = random.nextInt(rooms.size());
            List<Food> foodOfRandomRoom = rooms.get(randomRoom).getFood();
            if (!foodOfRandomRoom.isEmpty()) {
                collectedFood.addAll(foodOfRandomRoom);
                foodOfRandomRoom.clear();
                countRooms--;
                System.out.println("Room #" + randomRoom + " is clean.");
            }
        }
    }

    public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (!room.getFood().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
