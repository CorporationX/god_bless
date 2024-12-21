package school.faang.sprint_3.task_48730;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {
    private static final int AMOUNT_OF_THREADS = 5;

    public static void main(String[] args) {
        final int amountOfLettersToSend = 1000;
        final int amountOfLettersPerThread = amountOfLettersToSend / AMOUNT_OF_THREADS;

        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);

        try {
            List<Future<String>> futures = IntStream.range(0, AMOUNT_OF_THREADS)
                    .mapToObj(threadIndex -> {
                        int startIndex = threadIndex * amountOfLettersPerThread + 1;
                        int endIndex = startIndex + amountOfLettersPerThread;
                        return executorService.submit(new SenderRunnable(startIndex, endIndex));
                    })
                    .toList();

            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Произошла ошибка при отправке писем.");
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            System.out.println("Все письма успешно отправлены!");
        }
    }
}


