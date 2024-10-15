package school.faang.mice_are_nice_BJS2_35995;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public class House {
    public List<Room> rooms;
    public List<Food> collectedFood;

    public void collectFood() {
        if (rooms.size() == 1) {
            collectedFood.addAll(rooms.get(0).getFood());
            rooms.get(0).deleteAllFood();
            return;
        }
        Random random = new Random();
        int randomNum1 = random.nextInt(rooms.size());
        int randomNum2 = random.nextInt(rooms.size());

        Room room1 = rooms.get(randomNum1);
        collectedFood.addAll(room1.getFood());
        rooms.get(randomNum1).deleteAllFood();

        Room room2 = rooms.get(randomNum2);
        collectedFood.addAll(room2.getFood());
        rooms.get(randomNum2).deleteAllFood();
    }

    public boolean isFoodCollected() {
        return (rooms.stream().allMatch(room -> room.getFood().isEmpty()));
    }
}
