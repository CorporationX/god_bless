package school.faang.thirdStream.BJS2_35993;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        Random rnd = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        String[] characters = {
                "Peter Griffin",
                "Lois Griffin",
                "Stewie Griffin",
                "Meg Griffin",
                "Brian Griffin",
                "Glenn Quagmire",
                "Chris Griffin"
        };

        for (String character : characters) {
            int foodAmount = rnd.nextInt(1, 51);
            executorService.execute(new FoodDeliveryTask(character, foodAmount));
        }

        executorService.shutdown();
    }
}
