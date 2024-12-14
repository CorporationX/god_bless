package school.faang.task_47727;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);
        String[] characterNames = new String[]{"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(200);
            executorService.submit(new FoodDeliveryTask(character, foodAmount));
        }

        executorService.close();
    }
}
