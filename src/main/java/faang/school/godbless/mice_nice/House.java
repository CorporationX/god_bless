package faang.school.godbless.mice_nice;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class House {
    private static final int THREAD_NUM = 5;
    private static final int PLAN_CONSTRUCTION_TIME = 30;
    private static final int TIME_OUT = 100;
    private static final int FIRST_MET_FOOD = 0;
    private int roomIndex = 0;

    private final List<Room> roomList;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_NUM);

        House houseToSteelFood = new House(getRoomList());
        List<Food> stolenFoodList = new ArrayList<>();

        for (int i = 0; i < THREAD_NUM; i++) {
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
            log.info("Now house rooms look like this: " + houseToSteelFood.roomList.toString());
        } catch (InterruptedException e) {
            log.warn("Mission Failed, we have losses");
        }
    }

    public void collectFood(List<Food> stolenFoodList) {
        for (int i = 0; i < 2; i++) {
            Room roomToSteelFood;

            synchronized (this) {
                if (roomIndex < roomList.size()) {
                    roomToSteelFood = roomList.get(roomIndex);
                    roomIndex++;
                } else {
                    log.info("There is no room to steel food from.");
                    return;
                }
            }

            log.info("Started collecting food");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            steelFoodFromRoom(roomToSteelFood, stolenFoodList);
            log.info("Ended collecting");
        }
    }

    private void steelFoodFromRoom(@NonNull Room roomToSteelFood,
                                   @NonNull List<Food> stolenFoodList) {
        List<Food> foodList = roomToSteelFood.getRoomFoodList();
        int initialFoodListSize = foodList.size();

        for (int i = 0; i < initialFoodListSize; i++) {
            Food food = foodList.remove(FIRST_MET_FOOD);

            synchronized (this) {
                stolenFoodList.add(food);
            }
        }
    }

    private static List<Room> getRoomList() {
        return List.of(
                new Room("Kitchen", getFoodList(List.of("Cake", "Cheese", "Jam"))),
                new Room("Living room", getFoodList(List.of("Cheese", "Jam", "Flakes"))),
                new Room("Bedroom", getFoodList(List.of("Jam", "Flakes", "Butter"))),
                new Room("Dinning room", getFoodList(List.of("Flakes", "Butter", "Bread"))),
                new Room("Hall", getFoodList(List.of("Butter", "Bread", "Eggs"))),
                new Room("Bathroom", getFoodList(List.of("Bread", "Eggs", "Milk"))),
                new Room("Garage", getFoodList(List.of("Jam", "Flakes", "Butter"))),
                new Room("Terrace", getFoodList(List.of("Flakes", "Butter", "Bread"))),
                new Room("AnotherBedroom", getFoodList(List.of("Butter", "Bread", "Eggs"))),
                new Room("AnotherKitchen", getFoodList(List.of("Bread", "Eggs", "Milk")))
        );
    }

    private static List<Food> getFoodList(List<String> foodNames) {
        List<Food> foodList = new ArrayList<>();

        for (String foodName : foodNames) {
            foodList.add(new Food(foodName));
        }

        return foodList;
    }
}
