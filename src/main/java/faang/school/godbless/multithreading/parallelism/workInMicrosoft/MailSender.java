package faang.school.godbless.multithreading.parallelism.workInMicrosoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    private static final int LETTERS_AMOUNT = 1000;
    private static final int THREADS_AMOUNT = 5;
    private static final int LETTERS_FOR_ONE_THREAD = LETTERS_AMOUNT / THREADS_AMOUNT;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            int startIndex = i * LETTERS_FOR_ONE_THREAD + 1;
            int endIndex = (i + 1) * LETTERS_FOR_ONE_THREAD;
            executorService.submit(new SenderRunnable(startIndex, endIndex));
        }

        executorService.shutdown();

    }
}

