package faang.school.godbless.BJS223972;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for(String character : characterNames){
            int foodAmount = new Random().nextInt(5, 15);
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executor.submit(task);
        }
        executor.shutdown();
    }
}
