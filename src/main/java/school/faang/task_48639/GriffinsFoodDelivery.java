package school.faang.task_48639;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;

@Slf4j
public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random random = new Random();
        var executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (var name : characterNames) {
            executorService.submit(new FoodDeliveryTask(name, random.nextInt(1, 50)));
        }
        executorService.shutdown();
    }
}
