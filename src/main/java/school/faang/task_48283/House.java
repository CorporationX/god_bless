package school.faang.task_48283;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@ToString
@Slf4j
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectFoodInHouse = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoomToHouse(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        collectFoodFromRooms();
        log.info(Thread.currentThread().getName());
    }

    private void collectFoodFromRooms() {
        Random random = new Random();
        if (checkAllFoodCollected()) {
            return;
        }
        removeFoodFromRoom(rooms.get(random.nextInt(rooms.size())));
        removeFoodFromRoom(rooms.get(random.nextInt(rooms.size())));
    }

    private void removeFoodFromRoom(Room room) {
        List<Food> foods = room.getFoods();
        if (foods.isEmpty()) {
            System.out.println(String.format("There is no food in room %s", room.getName()));
            return;
        }
        collectFoodInHouse.addAll(foods);
        room.removeFood();
        System.out.println(String.format("All food was removed from %s", room.getName()));
    }

    public boolean checkAllFoodCollected() {
        return rooms.stream().flatMap(room -> room.getFoods().stream()).toList().isEmpty();
    }
}