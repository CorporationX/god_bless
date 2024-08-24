package faang.school.godbless.family_guy;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FamilyGuyFoodDelivery {
    private static final String[] GRIFFINS = {"Peter", "Lois", "Meg", "Chris", "Stewie", "Brian"};
    private static final long TIMEOUT = 9000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Arrays.stream(GRIFFINS)
                .map(fmn ->
                        new FoodDeliveryTask(fmn, (new Random()).nextInt(5) + 1)
                )
                .forEach(executor::submit);

        executor.shutdown();
        long startTime = System.currentTimeMillis();
        try {
            while (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                if (System.currentTimeMillis() - startTime > TIMEOUT) {
                    System.out.printf("Tasks failed to finish, timeout reached: %d%n", TIMEOUT);
                    executor.shutdownNow();
                } else {
                    System.out.println("--------- Tasks not finished yet...");
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("================================================");
        System.out.println("Thread pool finished executing!");
    }
}