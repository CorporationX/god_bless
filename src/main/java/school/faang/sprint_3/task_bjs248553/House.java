package school.faang.sprint_3.task_bjs248553;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
@ToString
public class House {
    @Getter
    private final List<Room> rooms;
    @Getter
    private final Queue<Food> collectedFood = new ConcurrentLinkedQueue<>();
    @Getter
    private final AtomicInteger roomsRemaining = new AtomicInteger();
    private Queue<Integer> roomIndexes = new ConcurrentLinkedQueue<>();


    public House(@NonNull List<Room> rooms) {
        this.rooms = rooms;
        roomIndexes = initializeRoomIndexes(rooms);
    }

    public void collectFood(int roomPerThread) {
        List<Integer> roomsToProcess;
        synchronized (this) {
            if (roomIndexes.isEmpty()) {
                log.info("No more rooms to work. Thread {} is waiting", Thread.currentThread().getName());
                return;
            }
            roomsToProcess = new ArrayList<>();
            IntStream.range(0, roomPerThread).forEach(value -> {
                Integer roomIndex = roomIndexes.poll();
                roomsRemaining.decrementAndGet();
                roomsToProcess.add(roomIndex);
                log.info("Thread {} roomIndex {} rooms remaining {}",
                        Thread.currentThread().getName(), roomIndex, roomsRemaining.get());
            });
        }

        roomsToProcess.stream()
                .filter(Objects::nonNull)
                .forEach(activeRoomIndex -> {
                    Room room = rooms.get(activeRoomIndex);
                    List<Food> c = room.collectFood();
                    collectedFood.addAll(c);
                    log.info("Thread {} processed room index {} room number {}",
                            Thread.currentThread().getName(), activeRoomIndex, room.getNumber());
                });
    }

    private Queue<Integer> initializeRoomIndexes(List<Room> inputData) {
        Collections.shuffle(inputData);

        Queue<Integer> indexes = new ConcurrentLinkedQueue<>();
        IntStream.range(0, inputData.size())
                .forEach(indexes::add);
        roomsRemaining.set(indexes.size());
        return indexes;
    }
}