package bjs2_36060;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GriffinsFoodDelivery {
    public static final int THREAD_POOL_SIZE = 3;
    public static final int MAX_TIME_LIMIT = 60;
    public static final int MAX_FOOD_AMOUNT = 50;
    public static final int MIN_FOOD_AMOUNT = 1;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Future<?> submit = service.submit(() -> Arrays.stream(characterNames).forEach(name -> {
            var task = new FoodDeliveryTask(name, random.nextInt(MAX_FOOD_AMOUNT) + MIN_FOOD_AMOUNT);
            service.execute(task);
        }));

        submit.get(MAX_TIME_LIMIT, TimeUnit.SECONDS);
        service.shutdown();
    }
}
