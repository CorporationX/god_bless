package faang.school.godbless.mice_are_very_nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        List<Room> toDelete = new ArrayList<>();

        synchronized (rooms) {
            for (int i = 0; i < 2; i++) {
                for (Food food : rooms.get(i).getFoods()) {
                    collectedFood.add(food);
                    toDelete.add(rooms.get(i));
                    System.out.printf("%s: %s collected from %s\n", Thread.currentThread().getName(), food.getName(), rooms.get(i).getName());
                }
            }
        }
        rooms.removeAll(toDelete);
    }
}