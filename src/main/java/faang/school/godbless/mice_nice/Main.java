package faang.school.godbless.mice_nice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_QUANTITY = 5;
    private static final int PLAN_CONSTRUCTION_TIME = 5;
    private static final int TIME_OUT = 60;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_QUANTITY);

        House houseToSteelFood = Informant.findHouseToSteelFood();
        List<Food> stolenFoodList = Collections.synchronizedList(new ArrayList<>());

        System.out.println(houseToSteelFood.getRoomList());
        System.out.println(stolenFoodList);

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            executor.schedule(
                    () -> Mouse.collectFood(houseToSteelFood, stolenFoodList), PLAN_CONSTRUCTION_TIME, TimeUnit.SECONDS
            );
        }

        executor.shutdown();

        try {
            boolean isMissionCompletedEntirely = executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
            if (isMissionCompletedEntirely) {
                System.out.println("All food is stolen");
            }
            System.out.println("Stolen food: " + stolenFoodList);
        } catch (InterruptedException e) {
            throw new RuntimeException("Mission Failed, we have losses");
        }

        System.out.println(houseToSteelFood.getRoomList());
        System.out.println(stolenFoodList);
    }
}
