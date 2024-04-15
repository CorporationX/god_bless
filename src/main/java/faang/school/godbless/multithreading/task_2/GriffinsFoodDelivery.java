package faang.school.godbless.multithreading.task_2;

import faang.school.godbless.multithreading.task_2.service.FoodDeliveryTask;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final Random RANDOM = new Random();
    private static final int NUMS_OF_THREADS = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUMS_OF_THREADS);

    public static void main(String[] args) {
        for (String name : CHARACTER_NAMES) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(name, RANDOM.nextInt(50));
            EXECUTOR.submit(foodDeliveryTask);
        }
        EXECUTOR.shutdown();
    }
}