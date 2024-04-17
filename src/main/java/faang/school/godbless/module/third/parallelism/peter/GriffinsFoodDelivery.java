package faang.school.godbless.module.third.parallelism.peter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        
        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt();
            System.out.printf("Персонаж %s получает");
            executorService.execute(new FoodDeliveryTask(characterName, foodAmount));
        }
        
        executorService.shutdown();
    }
}
