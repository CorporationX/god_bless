package school.faang.mice_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

@Setter
@Getter
@RequiredArgsConstructor
@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    private final CopyOnWriteArrayList<Room> readyToTidyRooms = new CopyOnWriteArrayList<>();
    private final Random random = new Random();

    public boolean collectFood() {
        synchronized (rooms) {
            IntStream.range(0, DataSet.AMOUNT_OF_ROOMS)
                    .mapToObj(number -> rooms.get(random.nextInt(DataSet.AMOUNT_OF_ROOMS)))
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

    private void preparedRoomsToTidy() {
        ArrayList<Room> modifiableList = new ArrayList<>(rooms);
        Collections.shuffle(modifiableList);
        readyToTidyRooms.addAll(modifiableList);
    }
}
