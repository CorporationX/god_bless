package school.faang.bjs248526;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Getter
public class House {
    private final List<Room> roomsList = Collections.synchronizedList(new ArrayList<>());
    private final List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());

    public void initialize() {
        Random random = new Random();
        roomsList.addAll(
                IntStream.rangeClosed(1, random.nextInt(20) + 1)
                        .mapToObj(roomNo -> new Room("Room no: " + roomNo,
                                IntStream.rangeClosed(1, random.nextInt(10) + 1)
                                        .mapToObj(foodNo -> new Food("Food no: " + foodNo + " for room no: " + roomNo))
                                        .toList()))
                        .toList()
        );
    }

    public boolean allFoodCollected() {
        return roomsList.stream().allMatch(room -> room.getFoodList().isEmpty());
    }

    public void collectFood() {
        System.out.println("Collect food on thread: " + Thread.currentThread().getId());
        Random random = new Random();

        synchronized (roomsList) {
            int count = (int) roomsList.stream()
                    .filter(Room::hasFood).count();

            for (int i = 0; i < (Math.min(count, Constants.ROOMS)); i++) {
                int roomId = random.nextInt(count);
                Room room = roomsList.get(roomId);
                Food foodData;

                synchronized (room) {
                    try {
                        foodData = room.getFoodList().stream()
                                .findFirst()
                                .orElseThrow(IllegalStateException::new);

                        synchronized (collectedFood) {
                            collectedFood.add(foodData);
                        }                        System.out.println("Food collected : " + foodData);
                        room.removeFood(foodData);
                        System.out.println("Food removed from " + room.getName());
                        if (!room.hasFood()) {
                            System.out.printf("%s has no food, removing it\n", room.getName());
                            roomsList.remove(roomId);
                            System.out.printf("%s has been removed!\n", room.getName());
                        }

                    } catch (Exception e) {
                        System.out.println("Error!");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}


