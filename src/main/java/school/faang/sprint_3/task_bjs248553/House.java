package school.faang.sprint_3.task_bjs248553;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

@Slf4j
@ToString
public class House {
    public static final int ROOMS_PER_THREAD = 2;
    private final Queue<Room> rooms;
    @Getter
    private final Queue<Food> collectedFood = new ConcurrentLinkedQueue<>();

    public House(@NonNull List<Room> rooms) {
        this.rooms = initializeRoomIndexes(rooms);
    }

    public void collectFood() {
        IntStream.range(0, ROOMS_PER_THREAD)
                .mapToObj(i -> rooms.poll())
                .filter(room -> Objects.nonNull(room) && !room.getFoods().isEmpty())
                .peek(room -> log.info("Thread {} will process room {} (remaining rooms: {})",
                        Thread.currentThread().getName(), room, rooms.size()))
                .forEach(room -> {
                    List<Food> c = room.collectFood();
                    collectedFood.addAll(c);
                    log.info("Thread {} collected food from room {}",
                            Thread.currentThread().getName(), room);
                });
    }

    public synchronized boolean isFoodCollected() {
        return rooms.isEmpty();
    }

    private Queue<Room> initializeRoomIndexes(List<Room> inputData) {
        Collections.shuffle(inputData);
        return new ConcurrentLinkedQueue<>(inputData);
    }
}