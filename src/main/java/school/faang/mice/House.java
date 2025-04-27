package school.faang.mice;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Slf4j
public class House {
    private final List<Room> rooms = new ArrayList<>();
    public final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        Room roomOne = rooms.get(ThreadLocalRandom.current().nextInt(rooms.size()));
        Room roomTwo;
        do {
            roomTwo = rooms.get(ThreadLocalRandom.current().nextInt(rooms.size()));
        } while (roomOne == roomTwo);

        log.info("Рандомно выбрали комнаты №№ [{} и {}]", roomOne.getRoomNumber(), roomTwo.getRoomNumber());

        collectedFood.addAll(roomOne.clearRoom());
        log.info("Собрали еду из комнаты № {}", roomOne.getRoomNumber());

        collectedFood.addAll(roomTwo.clearRoom());
        log.info("Собрали еду из комнаты № {}", roomTwo.getRoomNumber());
    }

    public boolean checkCollectedFood() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}