package piterGriffin_1001;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(1, 10);
            executorService.submit(() -> new FoodDeliveryTask(character, foodAmount).run());
        }
        executorService.shutdown();
    }
}