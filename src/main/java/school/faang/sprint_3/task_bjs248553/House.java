package school.faang.sprint_3.task_bjs248553;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@ToString
public class House {
    @Getter
    private final List<Room> rooms;
    @Getter
    private final List<Food> collectedFood = new CopyOnWriteArrayList<>();
    private final Queue<Integer> roomIndexes = new ConcurrentLinkedDeque<>();
    @Getter
    private final AtomicInteger roomsRemaining = new AtomicInteger();


    public House(@NonNull List<Room> rooms) {
        this.rooms = rooms;
        initializeRoomIndexes();
    }

    public void collectFood(int roomPerThread) {
        if (roomsRemaining.get() <= 0) {
            log.info("All rooms processed.");
            return;
        }

        List<Integer> roomsToProcess = new ArrayList<>();
        for (int i = 0; i < roomPerThread && !roomIndexes.isEmpty(); i++) {
            Integer roomIndex = roomIndexes.poll();
            roomsToProcess.add(roomIndex);
            log.info("Thread {} roomIndex {}", Thread.currentThread().getName(), roomIndex);
        }

        roomsToProcess.forEach(activeRoomIndex -> {
            Room room = rooms.get(activeRoomIndex);
            collectedFood.addAll(room.collectFood());
            room.clearFood();
            roomsRemaining.decrementAndGet();
            log.info("Thread {} processed room {}, update roomsRemaining to {}",
                    Thread.currentThread().getName(), activeRoomIndex, roomsRemaining.get());
        });
    }

    private void initializeRoomIndexes() {
        roomIndexes.addAll(IntStream.range(0, rooms.size())
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.shuffle(list);
                            return new ConcurrentLinkedDeque<>(list);
                        })));
        roomsRemaining.set(roomIndexes.size());
    }
}