package faang.school.godbless.BJS2_23690;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    static final int BATCH_SIZE = 200;
    static final int THREAD_COUNT = 5;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * BATCH_SIZE + 1;
            int endIndex = startIndex + BATCH_SIZE;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex) {
            });

            threads.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("Все письма отправлены!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
