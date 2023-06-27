package faang.school.godbless.multithreadingS4.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static List<Thread> threads;
    private static final int COUNT_THREADS = 5;

    public static void main(String[] args) {
        System.out.println("Main thread started.");

        fillThreads();
        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted", thread.getName());
            }
        });

        System.out.println("All messages have been sent successfully");
    }

    private static void fillThreads() {
        threads = new ArrayList<>(COUNT_THREADS);
        for (int i = 0; i < COUNT_THREADS; i++) {
            int startIndex = 200 * i + 1;
            int endIndex = startIndex + 199;
            String nameThread = String.format("Thread for indexes %d : %d", startIndex, endIndex);
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex), nameThread));
        }
    }
}
