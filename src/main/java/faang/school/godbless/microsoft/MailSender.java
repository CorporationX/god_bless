package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int PULL_OF_THREADS = 5;
    private static final int NUMBER_OF_LETTERS = 1000;
    private static final int BATCH_SIZE = NUMBER_OF_LETTERS/PULL_OF_THREADS;

    public static void main(String[] args) {
        List<Thread> containerThreads = new ArrayList<>(PULL_OF_THREADS);
        for (int i = 0; i < PULL_OF_THREADS; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = startIndex + BATCH_SIZE - 1 ;
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(sender);
            containerThreads.add(thread);
            containerThreads.get(i).start();
        }
        for (Thread thread : containerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All emails have been processed!");
    }
}
