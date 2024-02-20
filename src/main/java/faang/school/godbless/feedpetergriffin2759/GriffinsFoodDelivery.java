package faang.school.godbless.feedpetergriffin2759;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < CHARACTER_NAMES.length; i++) {
            executorService.submit(new FoodDeliveryTask(CHARACTER_NAMES[i], random.nextInt(20)));
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All fed and happy :)");
    }
}
