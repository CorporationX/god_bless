package faang.school.godbless.BJS2_11805;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Room implements Runnable {
    private final List<Food> foodInRoom = new ArrayList<>();
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foodInRoom.add(food);
    }

    public void collectFood(List<Food> src, List<Food> dest) {
        for (int i = 0; i < src.size(); i++) {
            Food collectedFood = src.remove(0);

            dest.add(collectedFood);
            System.out.println("Collected food " + collectedFood.getName() + " from room " + name);
        }
    }

    @Override
    public void run() {
        // собираем еду...
        collectFood(foodInRoom, House.food);
    }
}
