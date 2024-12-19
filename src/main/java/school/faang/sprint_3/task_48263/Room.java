package school.faang.sprint_3.task_48263;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private static final AtomicInteger ROOM_NUMBER_COUNTER = new AtomicInteger(1);
    private final int roomNumber;
    @NonNull
    private final List<Food> foodList;

    public Room(@NonNull List<Food> foodList) {
        this.roomNumber = ROOM_NUMBER_COUNTER.getAndIncrement();
        this.foodList = foodList;
    }

    public void addFood(@NonNull Food food) {
        foodList.add(food);
    }

    public void removeFood(@NonNull Food food) {
        foodList.remove(food);
    }

    public List<Food> getFoodList() {
        return List.copyOf(foodList);
    }

    public List<Food> collectAllFood() {
        List<Food> collectedFood = List.copyOf(foodList);
        foodList.clear();
        return collectedFood;
    }

    public boolean isAllFoodCollected() {
        return foodList.isEmpty();
    }

    @Override
    public String toString() {
        return "Room " + roomNumber;
    }
}
