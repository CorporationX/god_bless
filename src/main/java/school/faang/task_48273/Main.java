package school.faang.task_48273;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = setUpHouse();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Config.FIXED_THREAD_POOL_SIZE);
        executorService.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
            }
        }, 0, Config.FIXED_THREAD_POOL_DELAY, TimeUnit.SECONDS);

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                log.info("Food is collected: {} {}", house.getCollectedFood(), house.getCollectedFood().size());
            } else {
                executorService.shutdownNow();
                log.info("Food is not collected");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private static House setUpHouse() {
        House house = new House();

        String[] roomNames = {"Kitchen", "Bedroom", "Living", "Dining", "Bathroom",
                "Study", "Garage", "Attic", "Basement", "Library"};
        String[][] foods = {
                {"Apple", "Steak"},
                {"Milk", "Salad"},
                {"Cucumber", "Rice"},
                {"Pizza"},
                {"Bread", "Butter"},
                {"Chips", "Soda"},
                {"Carrot", "Potato"},
                {"Candy", "Chocolate"},
                {"Eggs", "Cheese"},
                {"Fish", "Tomato"}
        };

        for (int i = 0; i < roomNames.length; i++) {
            Room room = new Room(roomNames[i]);
            for (String foodName : foods[i]) {
                room.addFood(new Food(foodName));
            }
            house.addRoom(room);
        }

        return house;
    }

}
