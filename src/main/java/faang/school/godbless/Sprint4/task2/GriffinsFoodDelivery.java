package faang.school.godbless.Sprint4.task2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character: characterNames) {
            int foodAmount = new Random().nextInt(50);
            executor.execute(new FoodDeliveryTask(character, foodAmount));
        }
        executor.shutdown();
    }
}
