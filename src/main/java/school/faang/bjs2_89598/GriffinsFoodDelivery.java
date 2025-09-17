package school.faang.bjs2_89598;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    @SuppressWarnings({"checkstyle:LocalVariableName", "checkstyle:AbbreviationAsWordInName"})
    public static void main(String[] args) {
        int THREAD_AMOUNT = 3;
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (String character : characterNames) {
            int foodAmount = random.nextInt(3, 7);
            executor.execute(new FoodDeliveryTask(character, foodAmount));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            System.out.println("Поток main не смог должаться окончания, он был прерван.");
        }
    }
}
