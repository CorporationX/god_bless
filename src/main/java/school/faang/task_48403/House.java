package school.faang.task_48403;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private final List<Room> rooms;
    private final long countAllFoods;
    private final List<Food> allFoods = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
        countAllFoods = getCountAllFoodsInAllRooms();
    }

    public void collectFood() {
        removeFoodsFromRoom(getRandomNumberRoom());
    }

    public boolean allCollectedFood() {
        return countAllFoods == getCollectedFoods();
    }

    private int getCollectedFoods() {
        return allFoods.size();
    }

    private long getCountAllFoodsInAllRooms() {
        return rooms.stream()
                .mapToLong(m -> m.getFoods().size())
                .sum();
    }

    private void removeFoodsFromRoom(int numberRoom) {
        Room room = rooms.get(numberRoom);
        List<Food> foodsFromRoom = room.getFoods();
        if (!foodsFromRoom.isEmpty()) {
            log.info("In room = {} removing foods....", numberRoom);
            allFoods.addAll(foodsFromRoom);
            log.info("Collected foods: {}\nNumber foods collected = {}", allFoods, getCollectedFoods());
            room.removeFood();
            log.info("Room = {} is clean\n", numberRoom);
        } else {
            log.info("Room = {} is already cleaned\n", numberRoom);
        }
    }

    private int getRandomNumberRoom() {
        return new Random().nextInt(rooms.size());
    }
}
