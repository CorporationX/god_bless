package school.faang.task314.house;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private List<Room> rooms = new ArrayList<>();

    private List<Food> allFood = new ArrayList<>();

    public boolean isAllFoodCollected(){
        return rooms.stream().noneMatch(Room::hasFood);
    }
    public void collectFood() {
        Random random = new Random();
        Room firstRoom = rooms.get(random.nextInt(rooms.size()));
        Room secondRoom = rooms.get(random.nextInt(rooms.size()));

        if (firstRoom.hasFood() && secondRoom.hasFood()) {
            allFood.addAll(firstRoom.getAllfood());
            allFood.addAll(secondRoom.getAllfood());

            firstRoom.removeFood();
            secondRoom.removeFood();
        }
    }

    public void initialize() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(9) + 1; i++) {
            Room room = new Room();
            for (int j = 0; j < random.nextInt(5) + 1; j++) {
                room.addFood(new Food("Bread " + random.nextInt(99)));
            }
            rooms.add(room);
        }
    }
}
