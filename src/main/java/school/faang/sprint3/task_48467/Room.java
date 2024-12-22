package school.faang.sprint3.task_48467;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static school.faang.sprint3.task_48467.HouseSettings.FOOD_IN_ROOM_COUNT;

@Slf4j
@ToString
public class Room {
    private final int roomId;
    @NonNull
    private final List<Food> food = new ArrayList<>();
    private final AtomicBoolean inQueue = new AtomicBoolean(false);

    public Room(int roomId) {
        this.roomId = roomId;
        initFood();
    }

    public List<Food> collectFood() {
        List<Food> collected = new ArrayList<>(food);
        food.clear();
        return collected;
    }

    public boolean compareAndSetInQueue(boolean expected, boolean newValue) {
        return inQueue.compareAndSet(expected, newValue);
    }


    private void initFood() {
        List<Food> generated = IntStream.range(0, FOOD_IN_ROOM_COUNT)
                .mapToObj((i) -> new Food("food-" + i))
                .toList();
        food.addAll(generated);
    }

}
