package school.faang.sprint3.task_48467;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static school.faang.sprint3.task_48467.HouseSettings.FOOD_IN_ROOM_COUNT;

@Slf4j
@Getter
@ToString
public class Room {
    private final int roomId;
    @NonNull
    private final List<Food> food = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public Room(int roomId) {
        this.roomId = roomId;
        initFood();
    }

    public List<Food> collectFood() {
        lock.lock();
        try {
            List<Food> collected = new ArrayList<>(food);
            food.clear();
            return collected;
        } finally {
            log.info("RoomId = {}, food is collected by {} thread", roomId, Thread.currentThread().getName());
            lock.unlock();
        }
    }

    private void initFood() {
        List<Food> generated = IntStream.range(0, FOOD_IN_ROOM_COUNT)
                .mapToObj((i) -> new Food("food-" + i))
                .toList();
        food.addAll(generated);
    }

}
