package school.faang.sprint3.task_BJS2_61199;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);
    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        Arrays.stream(CHARACTER_NAMES).forEach(character -> EXECUTOR.submit(new FoodDeliveryTask(character)));
        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(CHARACTER_NAMES.length * (FoodDeliveryTask.MAX_SECOND + 1),
                    TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }

    }
}
