package school.faang.bjs2_91035;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    public static final int THREAD_POOL_SIZE = 3;
    public static final int WAITING_TIME_THREAD = 5;
    public static final Random random = new Random();

    public static void main(String[] args) {
        String[] characterNames = new String[]{"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (String characterName : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName,
                    random.nextInt(1, 100));
            executor.submit(foodDeliveryTask::run);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAITING_TIME_THREAD, TimeUnit.MINUTES)) {
                log.info("The waiting time for all streams has ended");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.info("Waiting was interrupted - Forced termination");
        }
    }
}
