package school.faang.task_48986;

import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Room {
    private final String name;
    private final CopyOnWriteArrayList<Food> food;

    public Room(String name, List<Food> food) {
        this.name = name;
        this.food = new CopyOnWriteArrayList<>(food);
    }

    @Override
    public String toString() {
        return "Room(" + '\'' + name + "', " + food + ")";
    }

    public Food pickFood() {
        if (food.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(food.size());
        Food pickedFood = food.get(randomIndex);
        food.remove(randomIndex);
        return pickedFood;
    }
}
