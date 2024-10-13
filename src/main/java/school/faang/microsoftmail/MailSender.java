package school.faang.microsoftmail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        final int COUNT_THREADS = 5;
        final int COUNT_LETTERS = 1000;

        int i = 0;
        int chunkSize = COUNT_LETTERS / COUNT_THREADS;
        List<Thread> threadList = new ArrayList<>();
        while (i < COUNT_LETTERS) {
            Thread newThread = new Thread(new SenderRunnable(i, i + chunkSize));
            threadList.add(newThread);
            newThread.start();
            i += chunkSize;
        }

        for (Thread th : threadList) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("The flow was interrupted during sleep.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
