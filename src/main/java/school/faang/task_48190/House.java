package school.faang.task_48190;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class House {
    private final List<Room> rooms;
    private List<Food> collectedFoods;

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("No rooms!");
            return;
        }

        Random randomIndex = new Random();
        int firstIndex;
        while (true) {
            firstIndex = randomIndex.nextInt(rooms.size());
            if (!rooms.get(firstIndex).foods().isEmpty()) {
                break;
            }
        }
        Room firstRoom = rooms.get(firstIndex);

        int secondIndex;
        while (true) {
            secondIndex = randomIndex.nextInt(rooms.size());
            if (firstIndex != secondIndex && !rooms.get(secondIndex).foods().isEmpty()) {
                break;
            }
        }
        Room secondRoom = rooms.get(secondIndex);

        if (firstRoom.foods().isEmpty() || secondRoom.foods().isEmpty()) {
            System.out.println("One of the rooms does not have food!");
            return;
        }

        Stream<Food> firstRandomFood = firstRoom.foods().stream();
        Stream<Food> secondRandomFood = secondRoom.foods().stream();
        collectedFoods.addAll(Stream.concat(firstRandomFood, secondRandomFood).toList());

        rooms.get(firstIndex).foods().clear();
        rooms.get(secondIndex).foods().clear();

        System.out.println(collectedFoods);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.foods().isEmpty());
    }
}
