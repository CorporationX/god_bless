package faang.school.godbless.feedpetergriffin;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static Random random = new Random();

    public static void main(String... args) throws IOException, InterruptedException {
        final int numberOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            executorService.submit(new FoodDeliveryTask(character, random.nextInt(30), random.nextInt(5000)));
        }
        executorService.shutdown();
        final boolean done = executorService.awaitTermination(1, TimeUnit.MINUTES);
        if (done) {
            System.out.println("Все задачи были выполнены");
        } else {
            System.out.println("Не все задачи были выполнены за отведенное время");
        }
    }
}
