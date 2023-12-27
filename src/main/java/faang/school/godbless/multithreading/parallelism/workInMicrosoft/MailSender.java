package faang.school.godbless.multithreading.parallelism.workInMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int LETTERS_AMOUNT = 1000;
    private static final int THREADS_AMOUNT = 5;
    private static final int LETTERS_FOR_ONE_THREAD = LETTERS_AMOUNT / THREADS_AMOUNT;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            int startIndex = (i == 0) ? i + 1 : i * LETTERS_FOR_ONE_THREAD + 1;
            int endIndex = (i == 0) ? LETTERS_FOR_ONE_THREAD : (i + 1) * LETTERS_FOR_ONE_THREAD;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            threads.get(i).start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}

