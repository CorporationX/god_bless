package school.faang.bjs2_73528;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Slf4j
public class HouseService {
    private static final int NUM_ROOMS = 2;
    private final House house;

    public List<Food> collectFood() {
        List<Food> collectedFood = house.getRooms().stream()
                .filter(Room::hasFood)
                .sorted(Comparator.comparingInt(r -> ThreadLocalRandom.current().nextInt()))
                .limit(NUM_ROOMS)
                .flatMap(room -> room.collectAndClearFood().stream())
                .toList();

        log.info("Food list in house {} assembled {}", house.getName(), collectedFood);
        return collectedFood;
    }

    public boolean allFoodCollected() {
        return house.getRooms().stream()
                .noneMatch(Room::hasFood);
    }
}
