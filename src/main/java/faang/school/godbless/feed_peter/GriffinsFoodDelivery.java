package faang.school.godbless.feed_peter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Stream.of(characterNames)
                .map(character -> {
                    int foodAmount = new Random().nextInt(100) + 1;
                    return new FoodDeliveryTask(character, foodAmount);
                })
                .forEach(executor::execute);

        executor.shutdown();
    }
}
