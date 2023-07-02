package faang.school.godbless.Multithreading.ParallelismAndThread.task02_FeedPeterGriffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int COUNT_THREAD = 3;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < COUNT_THREAD; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(
                    characterNames[FoodDeliveryTask
                            .getCharacter(characterNames.length)],
                    50
            );
            executorService.execute(foodDeliveryTask);
        }
        executorService.shutdown();
        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("All people are full");
        } else {
            System.out.println("Due to a mistake, people did not eat.");
        }
    }
}
