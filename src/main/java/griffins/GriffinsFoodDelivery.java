package griffins;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<String> characterNames = List.of("Peter", "Lois", "Meg", "Chris", "Stewie");

        characterNames.forEach((name -> {
            executor.execute(() -> {
                FoodDeliveryTask character = new FoodDeliveryTask(name, RANDOM.nextInt(1, 100));
                character.run();
            });
        }));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        System.out.println("Всех накормили!");
    }
}
