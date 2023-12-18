package faang.school.godbless.FeedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            int finalI = i;
            executor.submit(() -> new FoodDeliveryTask(characterNames[finalI], new Random().nextInt(50) + 1).run());
        }
        executor.shutdown();
    }
}
