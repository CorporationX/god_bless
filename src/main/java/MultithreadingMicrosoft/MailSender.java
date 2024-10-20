package MultithreadingMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static int TASKS = 1000;
    private static int THREADS = 5;
    private static int TASKS_PER_THREAD = TASKS / THREADS;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS; i++) {
            int startIndex = i * TASKS_PER_THREAD;
            int endIndex = (i + 1) * TASKS_PER_THREAD;
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }

        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Done successfully");
    }
}
