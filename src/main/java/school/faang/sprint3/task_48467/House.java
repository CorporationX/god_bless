package school.faang.sprint3.task_48467;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static school.faang.sprint3.task_48467.HouseSettings.ROOM_COUNT;

@Slf4j
public class House {
    private final List<Room> rooms = new CopyOnWriteArrayList<>();
    private final List<Food> collected = Collections.synchronizedList(new ArrayList<>());

    public House() {
        List<Room> generated = IntStream.range(0, ROOM_COUNT)
                .mapToObj(Room::new)
                .toList();
        rooms.addAll(generated);
    }

    public void collectFood() {
        List<Integer> indexes = generateTwoRandomRooms();
        for (Integer i : indexes) {
            List<Food> food = rooms.get(i).collectFood();
            collected.addAll(food);
        }
    }

    public void printAllCollectedFood() {
        System.out.println("Collected food: ");
        collected.forEach(System.out::println);
    }

    public boolean allFoodIsCollected() {
        synchronized (rooms) {
            return rooms.stream().allMatch((room) -> room.compareAndSetInQueue(true, true));
        }
    }

    private List<Integer> generateTwoRandomRooms() {
        List<Integer> roomsIndexes = new ArrayList<>();
        Random random = new Random();

        while (roomsIndexes.size() < 2) {
            if (allFoodIsCollected()) {
                break;
            }
            int generated = random.nextInt(rooms.size());
            Room room = rooms.get(generated);
            if (!roomsIndexes.contains(generated) && room.compareAndSetInQueue(false, true)) {
                roomsIndexes.add(generated);
            }
        }
        log.info(Thread.currentThread().getName() + " generated rooms " + roomsIndexes);
        return roomsIndexes;
    }
}
