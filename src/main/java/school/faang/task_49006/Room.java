package school.faang.task_49006;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public Room(List<Food> foods) {
        log.info("Created room with food list: {}", foods);
        this.foodList.addAll(foods);
    }

    public synchronized List<Food> collectFood() {
        List<Food> collected = new ArrayList<>(foodList);
        log.info("Food in room: {}", collected);
        foodList.clear();
        log.info("Collected: {}", collected);
        return collected;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    @Override
    public String toString() {
        return "Room with food: " + foodList;
    }
}
