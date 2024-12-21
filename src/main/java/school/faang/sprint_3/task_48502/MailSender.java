package school.faang.sprint_3.task_48502;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        List<Thread> threads = new ArrayList<>(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            SenderRunnable sender = new SenderRunnable(batchSize * i + 1, batchSize * i + batchSize);
            Thread thread = new Thread(sender);
            threads.add(thread);
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
