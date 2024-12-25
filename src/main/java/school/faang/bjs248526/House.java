package school.faang.bjs248526;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

@Getter
public class House {
    private final List<Room> roomsList = Collections.synchronizedList(new ArrayList<>());
    private final List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());


    public boolean allFoodCollected() {
        return roomsList.stream().allMatch(rm -> rm.getFoodList().isEmpty());
    }

    public void collectFood(ScheduledExecutorService executor) {
        Random random = new Random();
        synchronized (roomsList) {
            for (int i = 0; i < Constants.ROOMS; i++) {
                long nonEmptyRoomsCount = roomsList.stream()
                        .filter(rm -> !rm.getFoodList().isEmpty())
                        .count();
                if (nonEmptyRoomsCount == 0) {
                    executor.shutdown();
                    System.out.println("No more food to collect.");
                    return;
                }
                Room room = roomsList.get(random.nextInt((int) roomsList.stream()
                        .filter(rm -> !rm.getFoodList().isEmpty()).count()));
                var foodData = room.getFoodList().stream()
                        .findFirst()
                        .orElseThrow(IllegalStateException::new);
                collectedFood.add(foodData);
                System.out.println("Food collected : " + foodData);
                room.getFoodList().remove(foodData);
                if (room.getFoodList().isEmpty()) {
                    roomsList.remove(room);
                }
            }
        }
    }
}
