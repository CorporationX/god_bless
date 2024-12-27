package school.faang.task_48955;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public class House {

    private List<Room> rooms;
    private List<Food> foods = new ArrayList<>();

    public House() {
        rooms = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            rooms.add(new Room());
        }
    }

    public void collectFood() {
        Random rand = new Random();
        int room1Index, room2Index;
        do {
            room1Index = rand.nextInt(rooms.size());
            room2Index = rand.nextInt(rooms.size());
        } while (room1Index == room2Index);
        Room room1 = rooms.get(room1Index);
        Room room2 = rooms.get(room2Index);
        if (room1.hasFood() || room2.hasFood()) {
            if(room1.hasFood()) {
                foods.addAll(room1.getFoodList());
                System.out.println(Thread.currentThread().getName() + " collect food from room1");
            }
            if(room2.hasFood()) {
                foods.addAll(room2.getFoodList());
                System.out.println(Thread.currentThread().getName() + " collect food from room2");
            }
            rooms.get(room1Index).removeAllFood();
            rooms.get(room2Index).removeAllFood();
        }
    }

    public boolean hasCollectedAllFood() {
        return rooms.stream()
                .filter(Room::hasFood)
                .toList()
                .isEmpty();
    }
}
