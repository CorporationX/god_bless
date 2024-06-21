package faang.school.godbless.FeedPeterGriffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        final int QUANTITY_THREADS = 3;
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(QUANTITY_THREADS);

        for (int i = 0; i < characterNames.length; i++) {
            int amountOfFood = (int) (Math.random() * 10);
            executor.submit(new FoodDeliveryTask(characterNames[i], amountOfFood));
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Everyone is fed!");
    }
}
