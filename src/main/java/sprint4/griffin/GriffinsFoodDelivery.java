package sprint4.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int NUMBER_OF_CHARACTERS = 5;
    private static final int LIMIT_OF_ORDERED_FOOD = 50;
    private static final int NUMBER_THREADS = 3;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_THREADS);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (int i = 0; i < NUMBER_THREADS; i++) {
            service.execute(new FoodDeliveryTask(characterNames[random.nextInt(NUMBER_OF_CHARACTERS)],
                    random.nextInt(LIMIT_OF_ORDERED_FOOD)));
        }
        service.shutdown();
    }
}
