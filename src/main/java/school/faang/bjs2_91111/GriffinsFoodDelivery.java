package school.faang.bjs2_91111;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int MAX_FOOD_AMOUNT = 100;
    private static final int THREAD_POOL_SIZE = 3;
    private static final Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int foodAmount = random.nextInt(MAX_FOOD_AMOUNT) + 1;
            executor.submit(new FoodDeliveryTask(character, foodAmount));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Доставка затянулась, принудительно завершаем.");
                executor.shutdownNow();
            }
            System.out.println("Вся семья Гриффин накормлена!");
        } catch (InterruptedException e) {
            System.out.println("Доставка была прервана.");
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
