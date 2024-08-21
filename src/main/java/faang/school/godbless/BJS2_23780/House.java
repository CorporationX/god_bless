package faang.school.godbless.BJS2_23780;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public synchronized void collectFood(int numberRoom) {
        rooms.stream()
                .skip(numberRoom)
                .limit(2)
                .forEach(room -> {
                    List<Food> food = room.collectFood();
                    collectedFood.addAll(food);
                    System.out.println("Собрали еду из комнаты: " + room.getName() + " - " + food);
                });
    }

    public synchronized boolean allFoodCollected() {
        return rooms.stream().allMatch(Room::isFoodListEmpty);
    }
}
