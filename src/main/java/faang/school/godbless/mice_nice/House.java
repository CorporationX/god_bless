package faang.school.godbless.mice_nice;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@AllArgsConstructor
public class House {
    private static final int FIRST_MET_FOOD_INDEX = 0;
    private static final int FIRST_MET_ROOM_INDEX = 0;
    private static final int THREAD_QUANTITY = 5;
    private static final int PLAN_CONSTRUCTION_TIME = 30;
    private static final int TIME_OUT = 60;

    private List<Room> roomList;

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
            executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
            System.out.println("All food is stolen");
            System.out.println("Stolen food: " + stolenFoodList);
        } catch (InterruptedException e) {
            throw new RuntimeException("Mission Failed, we have losses");
        }
    }

    public void collectFood(List<Food> stolenFoodList) {
        for (int i = 0; i < 2; i++) {
            if (!roomList.isEmpty()) {
                Room roomToSteelFood = roomList.remove(FIRST_MET_ROOM_INDEX);

                steelFoodFromRoom(roomToSteelFood, stolenFoodList);
            } else {
                System.out.println("Wasted, there is no room to steel food from.");
                break;
            }
        }
    }

    private void steelFoodFromRoom(Room roomToSteelFood, List<Food> stolenFoodList) {
        List<Food> foodList = roomToSteelFood.getRoomFoodList();

        for (int i = 0; i < foodList.size(); i++) {
            stolenFoodList.add(foodList.remove(FIRST_MET_FOOD_INDEX));
        }
    }
}
