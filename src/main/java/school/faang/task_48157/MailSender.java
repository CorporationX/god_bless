package school.faang.task_48157;

import java.util.List;
import java.util.stream.Stream;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        List<Thread> threads;
        try {
            threads = createThreads(threadsCount, batchSize);

            threads.forEach(Thread::start);

            threads.forEach(thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.err.println("Поток был прерван: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            });

            System.out.println("Все сообщения успешно отправлены!");
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private static List<Thread> createThreads(int threadsCount, int batchSize) {
        return Stream.of(new Integer[threadsCount])
                .map(index -> new Thread(new SenderRunnable(index * batchSize, (index + 1) * batchSize)))
                .toList();
    }
}