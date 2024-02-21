package faang.school.godbless.petergriffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;
    private static int randomNumber = new Random().nextInt(100);

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_AMOUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.stream(characterNames).forEach((character)-> executors.submit(new FoodDeliveryTask(character,randomNumber)));
        executors.shutdown();
        try {
            executors.awaitTermination(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
