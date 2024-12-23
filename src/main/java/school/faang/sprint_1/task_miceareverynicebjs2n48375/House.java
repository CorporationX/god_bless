package school.faang.sprint_1.task_miceareverynicebjs2n48375;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
@Getter
public class House implements Runnable {
    @NonNull
    private final List<Room> rooms;
    @NonNull
    private final List<Food> food;
    @NonNull
    private final ScheduledExecutorService executorService;
    private int numberOfRoomsVisitedAtOnce = 2;


    public House(@NonNull List<Room> rooms,
                 @NonNull List<Food> food,
                 @NonNull ScheduledExecutorService executorService) {
        this.rooms = rooms;
        this.food = food;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try {
            collectFood();
            if (allFoodInHouseIsCollected()) {
                log.info(">>> All rooms are empty {} \n", rooms);
                throw new ExecutionException(new Throwable("collectFood() is successfully finished"));
            }
        } catch (ExecutionException e) {
            Thread.currentThread().interrupt();
            executorService.shutdown();
        }
    }

    public void collectFood() {
        List<Integer> numbersOfRoomsToVisit = new ArrayList<>(List.of(0, 0));
        numbersOfRoomsToVisit.replaceAll(numbers -> randomRoomIndex());
        if (allFoodInHouseIsCollected()) {
            log.info("All food in rooms is collected");
        } else {
            for (Integer integer : numbersOfRoomsToVisit) {
                food.addAll(rooms.get(integer).getFood());
                rooms.get(integer).removeFood();
            }
            log.info("rooms {} are visited by mice : {}", numbersOfRoomsToVisit, rooms);
        }
    }

    private int randomRoomIndex() {
        return (int) ((Math.random() * rooms.size()));
    }

    private boolean allFoodInHouseIsCollected() {
        for (Room room : rooms) {
            if (!room.getFood().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
