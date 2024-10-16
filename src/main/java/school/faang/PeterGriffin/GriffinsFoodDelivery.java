package school.faang.PeterGriffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Arrays.stream(characterNames).forEach(e -> service.submit(new FoodDeliveryTask(e, random.nextInt(100)+1)));
        service.shutdown();

        if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Timed out waiting for threads to finish");
            service.shutdownNow();
        }

        System.out.println("Done!");

    }
}
