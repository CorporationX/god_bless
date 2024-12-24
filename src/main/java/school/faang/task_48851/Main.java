package school.faang.task_48851;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        List<Food> collectionFood = new ArrayList<>();

        House house = new House("myHome", 3);

        ExecutorService executor = Executors.newScheduledThreadPool(5);

        while (House.isFoodAvailable(house)) {
            for (int i = 0; i < 100; i++) {
                executor.submit(
                    () -> {
                        house.collectFood(collectionFood, house);
                    });
            }

        }
        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
