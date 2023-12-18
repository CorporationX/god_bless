package faang.school.godbless.Piter;

import java.util.Random;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            executor.submit(new FoodDeliveryTask(characterNames[i], random.nextInt(30)));

        }
        executor.shutdown();
    }
}
