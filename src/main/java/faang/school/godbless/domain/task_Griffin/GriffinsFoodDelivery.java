package faang.school.godbless.domain.task_Griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String character : characterNames) {
            int count = new Random().nextInt(100);
            executor.execute(new FoodDeliveryTask(character, count));
        }

        executor.shutdown();
    }
}
