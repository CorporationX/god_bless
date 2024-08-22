package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    private static String getCharacter() {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        return characterNames[new Random().nextInt(characterNames.length)];
    }

    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new FoodDeliveryTask(getCharacter(), new Random().nextInt(12)));
            poolThreads.execute(thread);
        }
        poolThreads.shutdown();
        try {
            if (!poolThreads.awaitTermination(1300, TimeUnit.MILLISECONDS)) {
                poolThreads.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolThreads.shutdownNow();
        }
    }
}
