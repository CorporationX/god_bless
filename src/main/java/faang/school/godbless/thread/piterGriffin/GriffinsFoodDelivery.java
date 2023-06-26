package faang.school.godbless.thread.piterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (var name : characterNames) {
            int foodAmount = new Random().nextInt(25);
            executor.execute(new FoodDeliveryTask(name, foodAmount));
        }

        executor.shutdown();
    }
}
