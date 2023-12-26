package faang.school.godbless.multithreading.parallelism.workInMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int LETTERS_AMOUNT = 1000;
    private static final int THREADS_AMOUNT = 5;
    private static final int LETTERS_FOR_ONE_THREAD = LETTERS_AMOUNT / THREADS_AMOUNT;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0, j = 1; i < THREADS_AMOUNT; i++, j++) {
            threads.add(new Thread(new SenderRunnable(i * LETTERS_FOR_ONE_THREAD + 1, LETTERS_FOR_ONE_THREAD * j)));
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

