package faang.school.godbless.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class GriffinFoodDelivery {
    private static final int POOL_SIZE = 3;
    private static final int MAX_FOOD_AMOUNT = 100;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Stream.of(characterNames)
                .forEach(name -> service.submit(new FoodDeliveryTask(
                        name,
                        new Random().nextInt(MAX_FOOD_AMOUNT))));
        service.shutdown();
    }
}
