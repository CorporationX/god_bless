package faang.school.godbless.BJS223950;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt(9) + 1;
            executor.execute(new FoodDeliveryTask(characterName, foodAmount));
        }

        // Инициация безопасного завершения работы
        executor.shutdown();
        try {
            // Ожидание завершения всех задач в течение 5 секунд
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Принудительное завершение...");
                executor.shutdownNow(); // Принудительное завершение, если задачи не завершены
            }
        } catch (InterruptedException e) {
            System.err.println("Завершение прервано");
            executor.shutdownNow();
        }
    }
}
