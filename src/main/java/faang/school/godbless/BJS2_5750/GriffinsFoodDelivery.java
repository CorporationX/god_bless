package faang.school.godbless.BJS2_5750;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (String currentCharacter : characterNames) {
            executor.submit(new FoodDeliveryTask(currentCharacter, new Random().nextInt(50)));
        }

        executor.shutdown();
    }
}