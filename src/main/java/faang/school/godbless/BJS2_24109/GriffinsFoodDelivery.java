package faang.school.godbless.BJS2_24109;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(var character : characterNames) {
            executor.submit(new FoodDeliveryTask(character, new Random().nextInt(1, 20)));
        }

        executor.shutdown();
    }
}
