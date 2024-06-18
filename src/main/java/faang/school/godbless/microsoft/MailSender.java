package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int PULL_OF_THREADS = 5;
    private static final int NUMBER_OF_LETTERS = 1000;

    public static void main(String[] args) {
        List<Thread> containerThreads = new ArrayList<>(PULL_OF_THREADS);
        for (int i = 0; i < PULL_OF_THREADS; i++) {
            int startIndex = i * NUMBER_OF_LETTERS / PULL_OF_THREADS + 1;
            int endIndex = startIndex + NUMBER_OF_LETTERS / PULL_OF_THREADS - 1;
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
