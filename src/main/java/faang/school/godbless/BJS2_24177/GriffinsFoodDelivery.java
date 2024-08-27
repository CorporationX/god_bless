package faang.school.godbless.BJS2_24177;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            int index = i;
            int randomNumber = new Random().nextInt(1, 50);
            executorService.submit(() -> {
                new FoodDeliveryTask(characterNames[index], randomNumber).run();
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Время вышло. инициализируем shutdownNow.");
                List<Runnable> notExecutedTasks = executorService.shutdownNow();
                System.out.println("Количество не выполненых задач: " + notExecutedTasks.size());
            } else {
                System.out.println("Все задачи в пуле потоков выполенны");
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание завершения было прервано. Запускаем завершение работы прямо сейчас");
            List<Runnable> notExecutedTasks = executorService.shutdownNow();
            System.out.println("Количество не выполненых задач: " + notExecutedTasks.size());
            Thread.currentThread().interrupt();
        }
    }
}
