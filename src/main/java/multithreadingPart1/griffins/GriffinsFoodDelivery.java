package multithreadingPart1.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static final int THREADAMOUNT = 3;

    public static void main(String[] args) {
        Random rnd = new Random();
        String[] names = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(THREADAMOUNT);
        for (int i = 0; i < names.length; i++) {
            executorService.submit(new FoodDeliveryTask(names[i], rnd.nextInt(1, 50)));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Задачи не завершились");
                executorService.shutdownNow();
            } else {
                System.out.println("Задачи завершились");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
