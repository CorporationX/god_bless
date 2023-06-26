package faang.school.godbless.feed_peter_griffin;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for(int i = 0; i < 5; i++) {
            FoodDeliveryTask task = new FoodDeliveryTask(characterNames[i], (int)(Math.random()*100));
            executor.submit(() -> task.run());
        }
        if(executor.isTerminated()) {
            executor.shutdown();
        }
    }
}
