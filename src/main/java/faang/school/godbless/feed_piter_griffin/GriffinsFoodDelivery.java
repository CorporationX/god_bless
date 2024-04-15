package faang.school.godbless.feed_piter_griffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stevie"};

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String characterName : characterNames) {
            executorService.submit(new FoodDeliveryTask(characterName, ThreadLocalRandom.current().nextInt(1, 10)));
        }
        executorService.shutdown();
    }
}