package faang.school.godbless.petergriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (int i = 0; i < 1000; i++) {
            int randName = new Random().nextInt(characterNames.length);
            int randCount = new Random().nextInt(100);
            executor.submit(new FoodDeliveryTask(characterNames[randName],randCount));
        }
        executor.shutdown();
    }
}
