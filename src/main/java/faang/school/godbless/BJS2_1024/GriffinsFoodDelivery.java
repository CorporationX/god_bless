package faang.school.godbless.BJS2_1024;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        FoodDeliveryTask foodDeliveryTask1 = new FoodDeliveryTask(characterNames[0], new Random().nextInt(1, 100));
        FoodDeliveryTask foodDeliveryTask2 = new FoodDeliveryTask(characterNames[1], new Random().nextInt(1, 100));
        FoodDeliveryTask foodDeliveryTask3 = new FoodDeliveryTask(characterNames[2], new Random().nextInt(1, 100));
        FoodDeliveryTask foodDeliveryTask4 = new FoodDeliveryTask(characterNames[3], new Random().nextInt(1, 100));
        FoodDeliveryTask foodDeliveryTask5 = new FoodDeliveryTask(characterNames[4], new Random().nextInt(1, 100));
        List<FoodDeliveryTask> listOfConsumers = List.of(foodDeliveryTask1, foodDeliveryTask2, foodDeliveryTask3, foodDeliveryTask4, foodDeliveryTask5);
        for (FoodDeliveryTask foodDeliveryTask : listOfConsumers) {
            executorService.submit(foodDeliveryTask);
        }
        executorService.shutdown();
    }
}
