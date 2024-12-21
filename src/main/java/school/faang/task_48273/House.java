package school.faang.task_48273;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Slf4j
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public synchronized boolean collectFood() {
        if (allFoodCollected()) {
            return true;
        }

        Pair<Room, Room> roomPair = getTwoRandomRooms();

        collectedFood.addAll(
                roomPair.getLeft().collectFood());

        collectedFood.addAll(
                roomPair.getRight().collectFood());

        return allFoodCollected();
    }

    private boolean allFoodCollected() {
        return rooms.stream()
                .allMatch(room -> room.getFoods().isEmpty());
    }

    private Pair<Room, Room> getTwoRandomRooms() {
        List<Room> filteredRooms = rooms.stream()
                .filter(room -> !room.getFoods().isEmpty())
                .toList();

        if (filteredRooms.size() < 2) {
            throw new IllegalStateException("There must be at least two rooms with non-empty food lists.");
        }

        int firstIndex = ThreadLocalRandom.current().nextInt(filteredRooms.size());
        int secondIndex;

        do {
            secondIndex = ThreadLocalRandom.current().nextInt(filteredRooms.size());
        } while (secondIndex == firstIndex);

        return Pair.of(filteredRooms.get(firstIndex),
                filteredRooms.get(secondIndex));
    }

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }
}
