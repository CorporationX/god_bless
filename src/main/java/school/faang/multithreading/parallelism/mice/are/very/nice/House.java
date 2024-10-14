package school.faang.multithreading.parallelism.mice.are.very.nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Food> collectFood() {
        List<Room> roomsWithFood = rooms.stream()
                .filter(Room::hasFood)
                .toList();
        if (roomsWithFood.isEmpty()) {
            System.out.println("Нет еды для сбора");
            return Collections.emptyList();
        }
        if (roomsWithFood.size() == 1) {
            Room room = roomsWithFood.get(0);
            return room.removeAllFood();
        }

        Random random = new Random();
        int index1 = random.nextInt(roomsWithFood.size());
        int index2;
        do {
            index2 = random.nextInt(roomsWithFood.size());
        } while (index1 == index2);

        Room room1 = roomsWithFood.get(index1);
        Room room2 = roomsWithFood.get(index2);

        List<Food> collectedFood = new ArrayList<>();
        collectedFood.addAll(room1.removeAllFood());
        collectedFood.addAll(room2.removeAllFood());

        return collectedFood;
    }
}
