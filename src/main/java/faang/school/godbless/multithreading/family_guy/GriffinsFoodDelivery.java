package faang.school.godbless.multithreading.family_guy;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String character : characterNames) {
            int count = new Random().nextInt(100);
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(character, count);

            executor.submit(foodDeliveryTask);
            if (executor.awaitTermination(new Random().nextLong(1, 6), TimeUnit.SECONDS)) {
                System.out.println(character + " не поел");
            }
        }
        executor.shutdown();
    }
}