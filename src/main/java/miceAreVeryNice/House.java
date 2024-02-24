package miceAreVeryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new CopyOnWriteArrayList<>();
    }

    public void initialize() {
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            List<Food> foodList = new CopyOnWriteArrayList<>();
            for (int j = 0; j < 3; j++) {
                foodList.add(new Food("Food_" + random.nextInt(100)));
            }
            rooms.add(new Room(foodList));
        }
    }

    public void collectFood() {
        for (Room room : rooms) {
            List<Food> roomFoodList = room.getFoodList();
            collectedFood.addAll(roomFoodList);
            roomFoodList.clear();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            sb.append("Комната ").append(i + 1).append(": ").append(rooms.get(i)).append("\n");
        }
        sb.append("Собранная еда: ").append(collectedFood).append("\n");
        return sb.toString();
    }
}
