package school.faang.MiceAre9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Data
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        if (rooms.isEmpty() || rooms.stream().allMatch(room -> room.getFoods().isEmpty())) {
            return;
        }

        Random random = new Random();

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;
        do{
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while(room1==room2);

        if (room1.hasFood() || room2.hasFood()) {
            collectedFood.addAll(room1.getFoods());
            collectedFood.addAll(room2.getFoods());

            room1.getFoods().clear();
            room2.getFoods().clear();
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}
