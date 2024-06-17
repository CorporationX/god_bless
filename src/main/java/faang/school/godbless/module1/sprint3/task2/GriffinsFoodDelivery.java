package faang.school.godbless.module1.sprint3.task2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            service.submit(new FoodDeliveryTask(characterNames[i], getAmount()));
            if (!service.awaitTermination(new Random().nextLong(1,6),TimeUnit.SECONDS)) {
                System.out.println(characterNames[i] + " taking delivery");
                System.out.println(characterNames[i] + " eat");
            }
        }
        service.shutdown();
    }

    private static int getAmount() {
        return new Random().nextInt(1, 101);
    }
}
