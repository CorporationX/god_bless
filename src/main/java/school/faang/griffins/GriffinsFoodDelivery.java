package school.faang.griffins;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GriffinsFoodDelivery {
    private static final Logger LOGGER = Logger.getLogger(GriffinsFoodDelivery.class.getName());
    private static final int THREAD_POOLS = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOLS);
        String[] characterNames = {"Peter", "Louis", "Meg", "Chris", "Stewie"};

        for (String string : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(string);
            executor.submit(foodDeliveryTask);
        }

        executor.shutdown();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("All characters got random food");
    }
}
