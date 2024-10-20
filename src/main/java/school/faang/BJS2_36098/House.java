package school.faang.BJS2_36098;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public synchronized void collectFood() {
        Random random = new Random();
        int firstRoom = random.nextInt(rooms.size());
        int secondRoom = random.nextInt(rooms.size());
        while (firstRoom == secondRoom) {
            secondRoom = random.nextInt(rooms.size());
        }

        Room room1 = rooms.get(firstRoom);
        Room room2 = rooms.get(secondRoom);

        if (room1.hasFood() || room2.hasFood()) {
            System.out.println("Сбор еды из комант " + firstRoom + " и " + secondRoom);

            List<Food> foodFromRoom1 = room1.collectFood();
            List<Food> foodFromRoom2 = room2.collectFood();

            collectedFood.addAll(foodFromRoom1);
            collectedFood.addAll(foodFromRoom2);

            System.out.println("Количество собранной еды " + (foodFromRoom1.size() + foodFromRoom2.size()));
        } else {
            System.out.println("В комнатах пусто");
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}
