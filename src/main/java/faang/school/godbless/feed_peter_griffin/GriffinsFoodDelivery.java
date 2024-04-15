package faang.school.godbless.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String name : characterNames) {
            executorService.submit(new FoodDeliveryTask(name, new Random().nextInt(1, 10)));
        }
        executorService.close();
    }
}