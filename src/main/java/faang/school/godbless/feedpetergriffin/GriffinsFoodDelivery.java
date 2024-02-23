package faang.school.godbless.feedpetergriffin;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String... args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            executorService.submit(new FoodDeliveryTask(character, new Random().nextInt(30)));
        }
        executorService.shutdown();
    }
}
