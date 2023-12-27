package faang.school.godbless.alexbulgakoff.multithreading.parallelism;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class MailSender {
    static final int COUNT_THREADS = 5;
    static final int MESSAGES = 1000;
    private static final int NUMBER_OF_LETTERS_PER_THREAD = MESSAGES / COUNT_THREADS;

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < COUNT_THREADS; i++) {
            int startIndex = i * NUMBER_OF_LETTERS_PER_THREAD + 1;
            int endIndex = startIndex + NUMBER_OF_LETTERS_PER_THREAD;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            threadList.add(thread);
        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("All messages sent");
    }
}
