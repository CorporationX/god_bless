package faang.school.godbless.BJS2_12053;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (var character: characterNames) {
            executorService.submit(new FoodDeliveryTask(character, (int) (Math.random() * 21 + 1)));
        }

        executorService.shutdown();
    }
}
