package school.faang.mice.nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public House(Room... rooms) {
        this.rooms.addAll(List.of(rooms));
    }

    public void collectFood() {
        while (!rooms.isEmpty()) {
            Room room1 = rooms.get(new Random().nextInt(rooms.size()));
            Room room2 = rooms.get(new Random().nextInt(rooms.size()));

            while (room1 == room2) { room2 = rooms.get(new Random().nextInt(rooms.size())); }

            collectedFood.addAll(room1.getFoods());
            System.out.println(Thread.currentThread().getName() + " collects food from the room 1");
            collectedFood.addAll(room2.getFoods());
            System.out.println(Thread.currentThread().getName() + " collects food from the room 2");

            rooms.remove(room1);
            rooms.remove(room2);
        }
    }
}
