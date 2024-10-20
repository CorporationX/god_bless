package ru.kraiush.BJS2_36012;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characters = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characters) {
            FoodDeliveryTask deliveryTask = new FoodDeliveryTask(character, new Random().nextInt(1,101));
            executor.submit(deliveryTask);
        }

        executor.shutdown();
    }
}
