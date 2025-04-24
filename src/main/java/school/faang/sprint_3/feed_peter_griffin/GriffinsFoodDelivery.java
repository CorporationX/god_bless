package school.faang.sprint_3.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String [] characters = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String character : characters) {
            executorService.submit(new FoodDeliveryTask(character, random.nextInt(10) + 1));
        }
        executorService.shutdown();
    }
}
