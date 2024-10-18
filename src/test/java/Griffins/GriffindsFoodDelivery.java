package Griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffindsFoodDelivery {
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (String character : characterNames) {
            int foodAmount = random.nextInt(100) + 1;
            service.execute(new FoodDeliveryTask(character, foodAmount));
        }
        service.shutdown();
    }
}
