package faang.school.godbless.BJS2_23780;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Setter
@Getter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new CopyOnWriteArrayList<>();;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood(List<Room> assignedRooms) {
        List<Food> localCollectedFood = new ArrayList<>();
        for (Room room : assignedRooms) {
            List<Food> food = room.collectFood();
            localCollectedFood.addAll(food);
            System.out.println("Собрали еду из комнаты: " + room.getName() + " - " + food);
        }
        collectedFood.addAll(localCollectedFood);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(Room::isFoodListEmpty);
    }
}
