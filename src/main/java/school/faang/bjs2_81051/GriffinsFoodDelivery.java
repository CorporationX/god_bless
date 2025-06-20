package school.faang.bjs2_81051;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
@Slf4j
public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] charactersName = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        log.info("Начало доставки еды для семьи Гриффинов...");
        for (String character : charactersName) {
            int randomFoodAmount = ThreadLocalRandom.current().nextInt(1, 101);
            executorService.submit(new FoodDeliveryTask(character, randomFoodAmount));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Все заказы отправлены на выполнение");
    }
}
