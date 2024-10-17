package school.faang.BJS2_37791_WorkingInMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int MAILS_COUNT = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int packageSize = MAILS_COUNT / THREADS_COUNT;
        List<Thread> threads = new ArrayList<>();

        for (int startIndex = 1; startIndex < MAILS_COUNT; startIndex += packageSize) {
            int endIndex = startIndex + packageSize - 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        System.out.println("\nThreads have finished theirs work!");
    }
}
