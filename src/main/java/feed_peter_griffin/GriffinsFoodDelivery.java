package feed_peter_griffin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(3);
    private static final List<String> CHARACTER_NAMES = List.of("Peter", "Lois", "Meg", "Chris", "Stewie");
    private static final int FOOD_AMOUNT = 50;
    private static final int AWAIT_SECONDS = 30;

    /**
     * Runs the food delivery task for each Griffin family member.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) throws InterruptedException {
        List<FoodDeliveryTask> tasks = new ArrayList<>();

        CHARACTER_NAMES.forEach(character -> tasks.add(new FoodDeliveryTask(character, FOOD_AMOUNT)));

        tasks.forEach(SERVICE::submit);

        SERVICE.shutdown();

        if (SERVICE.awaitTermination(AWAIT_SECONDS, TimeUnit.SECONDS)) {
            tasks.forEach(character -> System.out.printf("%s eats %d %s\n", character.getCharacter(), character.getFoodAmount(), character.getFoodType()));
        } else {
            System.out.println("Food delivery task timed out");
            SERVICE.shutdownNow();
        }
    }
}
