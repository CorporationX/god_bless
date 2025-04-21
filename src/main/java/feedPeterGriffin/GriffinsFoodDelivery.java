package feedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = new String[]{"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String character : characterNames) {
            executorService.submit(new FoodDeliveryTask(character, random.nextInt(10) + 1));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println(" Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executorService.shutdownNow();
            } else {
                System.out.println(" Все доставки выполнены успешно.");
            }
        } catch (InterruptedException e) {
            System.out.println(" Главный поток был прерван.");
            executorService.shutdownNow();
        }
    }
}
