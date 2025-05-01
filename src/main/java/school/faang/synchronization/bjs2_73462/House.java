package school.faang.synchronization.bjs2_73462;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private final BlockingDeque<Room> shuffledRooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
        Collections.shuffle(this.rooms);
        this.shuffledRooms = new LinkedBlockingDeque<>(this.rooms);
    }

    public void collectFood() {
        if (!this.shuffledRooms.isEmpty()) {
            Room room1 = this.shuffledRooms.pop();
            Room room2 = this.shuffledRooms.pop();
            synchronized (collectedFood) {
                collectedFood.addAll(room1.clearFood());
                collectedFood.addAll(room2.clearFood());
            }
            log.info("Еда из комнат номер {} и {} собрана\n", room1.getNumber(), room2.getNumber());
        }
    }

    public boolean allFoodCollected() {
        return rooms.isEmpty();
    }

    public synchronized void printRooms() {
        rooms.forEach(room -> log.info(String.valueOf(room)));
    }

    public synchronized void printCollectedFood() {
        collectedFood.forEach(food -> log.info(String.valueOf(food)));
    }
}
