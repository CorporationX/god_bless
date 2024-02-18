package faang.school.godbless.feedgriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (var character : characterNames) {
            executorService.submit(new FoodDeliveryTask(character, new Random().nextInt(5) + 1));
        }
        executorService.shutdown();
    }
}
