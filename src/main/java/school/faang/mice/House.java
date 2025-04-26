package school.faang.mice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class House {
    private final List<Room> rooms = new ArrayList<>();
    public final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        Room roomOne = rooms.get(ThreadLocalRandom.current().nextInt(rooms.size()));
        Room roomTwo;
        do {
            roomTwo = rooms.get(ThreadLocalRandom.current().nextInt(rooms.size()));
        } while (roomOne == roomTwo);
        log.info("Рандомно выбрали комнаты [{} и {}]", roomTwo, roomTwo);

        Food foodOne = roomOne.getFoods().remove(0);
        log.info("Убрали еду {} из комнаты {}", foodOne, roomOne);
        Food foodTwo = roomTwo.getFoods().remove(0);
        log.info("Убрали еду {} из комнаты {}", foodTwo, roomTwo);

        collectedFood.add(foodOne);
        collectedFood.add(foodTwo);
    }

    public boolean checkCollectedFood() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}
