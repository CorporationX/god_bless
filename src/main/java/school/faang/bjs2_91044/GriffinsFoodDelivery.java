package school.faang.bjs2_91044;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final String[] GRIFFINS = {
            "Питер Гриффин", "Лоис Гриффин", "Брайан Гриффин",
            "Крис Гриффин", "Мэг Гриффин", "Стьюи Гриффин",
    };
    private static final int MIN_FOOD_AMOUNT = 1;
    private static final int MAX_FOOD_AMOUNT = 100;

    private static final int THREAD_COUNTER = 3;
    private static final int ONE_MINUTE_WAITING = 1;

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNTER);

        for (String griffin : GRIFFINS) {
            executor.execute(
                    new FoodDeliveryTask(griffin, random.nextInt(MIN_FOOD_AMOUNT, MAX_FOOD_AMOUNT + 1))
            );
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(ONE_MINUTE_WAITING, TimeUnit.MINUTES)) {
                System.out.println("Из-за неизвестных причин доставка невозможна - все курьеры остановлены.");
                executor.shutdownNow();
            } else {
                System.out.println("Доставка завершена - Дом Гриффиных полон еды и счастья!");
            }
        } catch (InterruptedException e) {
            System.out.println("Все доставки отменены в связи с крахом компании!");
            Thread.currentThread().interrupt();
        }
    }
}
