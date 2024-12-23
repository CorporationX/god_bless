package school.faang.mice_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

@Setter
@Getter
@RequiredArgsConstructor
@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    private final Queue<Room> readyToTidyRooms = new ConcurrentLinkedQueue<>();

    public boolean collectFood() {
        synchronized (collectedFood) {
            IntStream.range(0, 2)
                    .mapToObj(number -> readyToTidyRooms.poll()).filter(Objects::nonNull)
                    .filter(Room::hasFood)
                    .map(Room::removeAllFood)
                    .forEach(collectedFood::addAll);
        }

        if (hasAllFoodCollected()) {
            log.info("Done!");
            return true;
        }
        return false;
    }

    private synchronized boolean hasAllFoodCollected() {
        return collectedFood.size() == DataSet.TOTAL_AMOUNT_OF_FOODS;
    }

    public void preparedRoomsToTidy() {
        ArrayList<Room> modifiableList = new ArrayList<>(rooms);
        Collections.shuffle(modifiableList);
        readyToTidyRooms.clear();
        readyToTidyRooms.addAll(modifiableList);
    }
}
