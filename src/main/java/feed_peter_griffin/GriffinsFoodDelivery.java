package feed_peter_griffin;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int NUMBER_OF_EXECUTORS = 3;
    private static final int LIMIT_RANDOM = 50;
    private static final int WAITING_LIMIT_IN_MINUTES = 3;
    private static Random randomNum = new Random();

    @SneakyThrows
    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_EXECUTORS);
        Arrays.stream(characterNames).forEach((character) -> executorService.submit(new FoodDeliveryTask(character, randomNum.nextInt(LIMIT_RANDOM + 1))));
        executorService.shutdown();
        executorService.awaitTermination(WAITING_LIMIT_IN_MINUTES, TimeUnit.MINUTES);
    }
}