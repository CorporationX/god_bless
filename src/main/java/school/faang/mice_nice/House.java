package school.faang.mice_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

@Setter
@Getter
@RequiredArgsConstructor
@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public void collectFood() {
        if (hasAllFoodCollected()) {
            log.info("Done!");
            return;
        }
        synchronized (this) {
            IntStream.range(0, 2)
                    .mapToObj(number -> rooms.get(random.nextInt(DataSet.AMOUNT_OF_ROOMS)))
                    .filter(Room::hasFood)
                    .map(Room::removeAllFood)
                    .forEach(collectedFood::addAll);
        }
    }

    public synchronized boolean hasAllFoodCollected() {
        return collectedFood.size() == DataSet.TOTAL_AMOUNT_OF_FOODS;
    }
}
