package school.faang.synchronization.bjs2_73462;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

@Slf4j
@AllArgsConstructor
public class House {
    private static final int COUNT_ROOMS_TO_CLEAR = 2;
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood(BlockingDeque<Room> randomRooms) {
        for (int counter = 0; counter < COUNT_ROOMS_TO_CLEAR; counter++) {
            if (!randomRooms.isEmpty()) {
                Room room = randomRooms.pop();
                collectedFood.addAll(
                        room.clearFood());
                log.info("Еда из комнаты номер {} собрана\n", room.getNumber());
            }
        }
    }

    public boolean allFoodCollected() {
        return rooms.isEmpty();
    }

    public void printRooms() {
        for (var room : rooms) {
            log.info(String.valueOf(room));
        }
    }

    public void printCollectedFood() {
        for (var food : collectedFood) {
            log.info(String.valueOf(food));
        }
    }

}
