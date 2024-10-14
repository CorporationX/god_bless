package feed_peter_griffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(3);
    private static final String[] CHARACTER_NAMES = new String[]{"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int FOOD_AMOUNT = 50;

    /**
     * Runs the food delivery task for each Griffin family member.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        for (String characterName : CHARACTER_NAMES) {
            SERVICE.submit(new FoodDeliveryTask(characterName, FOOD_AMOUNT));
        }

        SERVICE.shutdown();
    }
}
