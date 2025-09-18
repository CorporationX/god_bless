package school.faang.bjs2_91050;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsDeliveryFood {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int WAITING_TIME = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewart"};

        for (String character : characterNames) {
            executorService.execute(new FoodDeliveryTask(character));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(WAITING_TIME, TimeUnit.SECONDS)) {
                System.out.println("Машины слишком задерживаются, что-то пошло не так. Отменяем доставку!");
                executorService.shutdownNow();
            } else {
                System.out.println("Оператор: Гриффины получили свои заказы!");
            }
        } catch (InterruptedException e) {
            System.out.println("Работа оператора была прервана!");
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
    }
}