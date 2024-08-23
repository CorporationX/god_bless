package faang.school.godbless.BJS2_25892;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String name : characterNames) {
            executor.submit(new FoodDeliveryTask(name, 1 + new Random().nextInt(50)));
        }
        executor.shutdown();
    }
}
