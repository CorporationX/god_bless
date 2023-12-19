package Thread_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String name : characterNames) {
            executor.submit(() -> new FoodDeliveryTask(name, (int) (Math.random() * 50)).run());
        }
        while (!executor.isTerminated()) {
            executor.shutdown();
        }
    }
}
