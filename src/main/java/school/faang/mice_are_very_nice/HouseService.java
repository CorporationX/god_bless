package school.faang.mice_are_very_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
public class HouseService {
    private static final int MAX_ROOMS_TO_COLLECT = 2;
    private final House house;
    private final Random randomFood = new Random();

    @Getter
    private final List<Food> collectedFood = Collections
            .synchronizedList(new ArrayList<>());

    private List<Integer> selectRandomRoomIndexes(List<Room> rooms) {
        return IntStream.range(0, rooms.size())
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), indexes -> {
                            Collections.shuffle(indexes, randomFood);
                            return indexes;
                        }))
                .stream()
                .limit(Math.min(HouseService.MAX_ROOMS_TO_COLLECT, rooms.size()))
                .toList();
    }

    private List<Food> collectFoodFromRooms(List<Room> rooms, List<Integer> roomIndexes) {
        return roomIndexes.stream()
                .map(rooms::get)
                .flatMap(room -> {
                    List<Food> roomFood = new ArrayList<>(room.foods());
                    room.foods().clear();
                    return roomFood.stream();
                })
                .toList();
    }

    public synchronized void collectFood() {
        List<Room> rooms = house.rooms()
                .stream()
                .filter(room -> !room.foods().isEmpty())
                .toList();

        List<Integer> roomIndexes = selectRandomRoomIndexes(rooms);
        List<Food> newlyCollectedFood = collectFoodFromRooms(rooms, roomIndexes);

        collectedFood.addAll(newlyCollectedFood);

        log.info("Collected {} food, from {} random rooms. Total food collected: {}.",
                newlyCollectedFood.size(), roomIndexes.size(), collectedFood.size());
    }

    public boolean isAllFoodCollected() {
        return house.rooms()
                .stream()
                .allMatch(room -> room.foods()
                        .isEmpty());
    }
}