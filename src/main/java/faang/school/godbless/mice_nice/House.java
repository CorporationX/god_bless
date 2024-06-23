package faang.school.godbless.mice_nice;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class House {
    private static final int THREAD_QUANTITY = 6;
    private static final int PLAN_CONSTRUCTION_TIME = 30;
    private static final int TIME_OUT = 60;

    private Queue<Room> roomList;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_QUANTITY);

        House houseToSteelFood = Informant.findHouseToSteelFood();
        List<Food> stolenFoodList = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            executor.schedule(
                    () -> houseToSteelFood.collectFood(stolenFoodList),
                    PLAN_CONSTRUCTION_TIME, TimeUnit.SECONDS
            );
        }

        executor.shutdown();

        try {
            boolean isMissionCompletedOnTime = executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
            if (isMissionCompletedOnTime) {
                log.info("All food is stolen");
            }
            log.info("Stolen food: " + stolenFoodList);
        } catch (InterruptedException e) {
            log.warn("Mission Failed, we have losses");
        }
    }

    @SneakyThrows // I take whole responsibility
    public void collectFood(List<Food> stolenFoodList) {
        for (int i = 0; i < 2; i++) {
            Room roomToSteelFood = null;

            synchronized (this) {
                if (!roomList.isEmpty()) {
                    roomToSteelFood = roomList.poll();
                }
            }

            if (roomToSteelFood != null) {
                log.info("Started collecting food");

                Thread.sleep(3000);

                steelFoodFromRoom(roomToSteelFood, stolenFoodList);
                log.info("Ended collecting");
            } else {
                log.info("There is no room to steel food from.");
                break;
            }
        }
    }

    private void steelFoodFromRoom(@NonNull Room roomToSteelFood,
                                   @NonNull List<Food> stolenFoodList) {
        Queue<Food> foodList = roomToSteelFood.getRoomFoodList();

        for (int i = 0; i < foodList.size(); i++) {
            stolenFoodList.add(foodList.poll());
        }
    }
}
