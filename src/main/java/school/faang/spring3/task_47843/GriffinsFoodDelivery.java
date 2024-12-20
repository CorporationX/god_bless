package school.faang.spring3.task_47843;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int COUNT_THREAD = 3;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(COUNT_THREAD);
        for (String s : characterNames) {
            service.execute(new FoodDeliveryTask(s, random.nextInt(100) + 1));
        }
        service.shutdown();
    }
}
