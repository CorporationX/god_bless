package faang.school.godbless.multithreading.feedgriffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static final int MAX_FOOD_AMOUNT = 15;
    public static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random rand = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Arrays.stream(characterNames).forEach(
                character -> executor.submit(
                        new FoodDeliveryTask(character, rand.nextInt(MAX_FOOD_AMOUNT))));

        executor.shutdown();
    }

}
