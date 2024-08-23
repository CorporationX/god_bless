package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Питер", "Лоис", "Мэг", "Крис", "Стьюи"};

         for (String character : characterNames) {
            int foodAmount = ThreadLocalRandom.current().nextInt(10, 101);
            executorService.submit(new FoodDeliveryTask(character, foodAmount));
        }
        executorService.shutdown();
    }
}