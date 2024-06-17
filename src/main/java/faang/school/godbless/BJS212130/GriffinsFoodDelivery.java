package faang.school.godbless.BJS212130;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int MIN_AMOUNT = 1;
    private static final int MAX_AMOUNT = 101;
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        List<String> characters = List.of(characterNames);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (var name : characters) {
            int foodAmount = new Random().nextInt(MIN_AMOUNT, MAX_AMOUNT);
            executorService.execute(new FoodDeliveryTask(name, foodAmount));
        }
        executorService.shutdown();

    }
}
