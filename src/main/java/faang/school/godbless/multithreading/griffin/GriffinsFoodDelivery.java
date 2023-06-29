package faang.school.godbless.multithreading.griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        Arrays.stream(characterNames)
                .parallel()
                .forEach(character ->
            executor.submit(new FoodDeliveryTask(character, random.nextInt(1, 100))));

        executor.shutdown();
    }
}
