package school.faang.sprint_3.task_48167;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final int AMOUNT_OF_THREADS = 5;

    public static void main(String[] args) {
        int amountOfLettersToSend = 1000;
        int amountOfLettersToOneThread = 200;

        int startIndex = 1;

        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);
        List<Future<String>> futures = new ArrayList<>();
        while (startIndex <= amountOfLettersToSend) {
            futures.add(executorService
                    .submit(new SenderRunnable(startIndex, startIndex += amountOfLettersToOneThread)));
        }

        try {
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Отправка сообщений прервана");
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
