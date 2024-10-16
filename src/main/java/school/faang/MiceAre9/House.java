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
            System.out.println("В комнатах больше нет еды.");
            return;
        }

        Random random = new Random();

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;
        do{
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while(room1==room2);

        if (!room1.hasFood() || !room2.hasFood()) {
            System.out.println("Not enough food to collect");
            return;
        }

        int index1 = random.nextInt(room1.getFoods().size());
        int index2 = random.nextInt(room2.getFoods().size());

        collectedFood.add(room1.getFoods().get(index1));
        collectedFood.add(room2.getFoods().get(index2));

        room1.getFoods().remove(index1);
        room2.getFoods().remove(index2);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}
