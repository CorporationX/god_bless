package school.faang.sprint3.task_48467;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static school.faang.sprint3.task_48467.HouseSettings.ROOM_COUNT;

@Slf4j
public class House {
    private final List<Room> rooms = new CopyOnWriteArrayList<>();
    private final List<Food> collected = Collections.synchronizedList(new ArrayList<>());
    private final AtomicInteger clearedRooms = new AtomicInteger();

    public House() {
        List<Room> generated = IntStream.range(0, ROOM_COUNT)
                .mapToObj(Room::new)
                .toList();
        rooms.addAll(generated);
    }

    public void collectFood() {
        Random random = new Random();
        int generatedRooms = 0;

        while (generatedRooms < 2) {
            if (allFoodIsCollected()) {
                return;
            }

            int generated = random.nextInt(rooms.size());
            Room room = rooms.get(generated);

            if (room.getLock().tryLock() && !room.getFood().isEmpty()) {
                List<Food> food = room.collectFood();
                collected.addAll(food);
                generatedRooms++;
                clearedRooms.incrementAndGet();
            }
        }
    }

    public void printAllCollectedFood() {
        System.out.println("Collected food: ");
        collected.forEach(System.out::println);
    }

    public boolean allFoodIsCollected() {
        return clearedRooms.get() == rooms.size();
    }
}
