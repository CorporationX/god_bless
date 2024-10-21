package school.faang.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_NUMBER = 3;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (String name : characterNames) {
            int randomAmount = random.nextInt(100) + 1;
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(name, randomAmount);
            service.execute(foodDeliveryTask);
        }
    }

}
