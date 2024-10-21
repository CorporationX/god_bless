package faang.school.godbless.mt.mice;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private final List<Room> rooms;
    @Getter
    private final List<Food> takenFoods;

    public House(List<Room> rooms) {
        this.rooms = new ArrayList<>(rooms);
        this.takenFoods = new ArrayList<>();
    }

    public void collectFood() {
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));
        List<Food> takenFoodFromRoom1 = room1.takeFood();
        List<Food> takenFoodFromRoom2 = room2.takeFood();
        takenFoods.addAll(takenFoodFromRoom1);
        takenFoods.addAll(takenFoodFromRoom2);
        log.info("Taken food: {} {}", takenFoodFromRoom1, takenFoodFromRoom2);
    }

    public boolean roomsContainsFood() {
        return rooms.stream().anyMatch(Room::hasFood);
    }
}
