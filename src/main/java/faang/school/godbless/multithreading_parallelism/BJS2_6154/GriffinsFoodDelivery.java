package faang.school.godbless.multithreading_parallelism.BJS2_6154;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<String> characterNames = List.of("Peter", "Lois", "Meg", "Chris", "Stewie");

        characterNames.forEach(name -> executor.execute(() -> {
            FoodDeliveryTask character = new FoodDeliveryTask(name, new Random().nextInt(1, 100));
            character.run();
        }));

        executor.shutdown();
        System.out.println("Everybody's happy!");
    }
}
