package school.faang.sprint3.task_48452;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    private static final int numberOfThreads = 5;
    private static final int numberOfMessages = 1000;

    public static void main(String[] args) {
        int batchSize = numberOfMessages / numberOfThreads;

        List<Thread> threads = IntStream.range(0, numberOfThreads)
                .mapToObj((i) -> new SenderRunnable(i * batchSize, batchSize * (i + 1)))
                .map((sender) -> new Thread(sender))
                .toList();

        threads.forEach(Thread::start);

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
