package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int THE_NUMBERS_OF_EMAILS_TO_SEND = 1000;
    public static final int THE_NUMBERS_OF_THREADS = 5;
    public static void main(String[] args) {

        int theNumberOfEmailsInTheThread = THE_NUMBERS_OF_EMAILS_TO_SEND / THE_NUMBERS_OF_THREADS;

        List<Thread> runingThreads = new ArrayList<Thread>();

        for (int i = 0; i < THE_NUMBERS_OF_THREADS; i++) {
            int startIndex = i * theNumberOfEmailsInTheThread + 1;
            int endIndex = startIndex + theNumberOfEmailsInTheThread -1;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            runingThreads.add(thread);
        }
        runingThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("All messages have been sent.");
    }
}