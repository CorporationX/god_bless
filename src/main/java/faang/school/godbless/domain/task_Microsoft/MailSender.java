package faang.school.godbless.domain.task_Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int MESSAGE_COUNT = 1000;
    public static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        int batchSize = MESSAGE_COUNT / THREAD_COUNT;
        for (int i = 0; i < THREAD_COUNT; i++) {

            Thread thread = new Thread(new SenderRunnable(i * batchSize, i * batchSize + batchSize));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }


    }
}
