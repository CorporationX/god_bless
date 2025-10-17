package school.faang.sprint3.mail.sender;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {

    public static final Integer THREAD_COUNT = 3;
    public static final Integer MESSAGE_COUNT = 10;

    public static void main(String[] args) {

        int actualThreadCount = Math.min(THREAD_COUNT, MESSAGE_COUNT);
        int batchSize = Math.max(1, (int) Math.ceil((double) MESSAGE_COUNT / actualThreadCount));
        List<Thread> threads = IntStream.range(0, actualThreadCount)
                .mapToObj(batchIndex -> {
                    int start = batchIndex * batchSize;
                    int end = Math.min(start + batchSize, MESSAGE_COUNT);
                    Thread thread = new Thread(new SenderRunnable(start, end));
                    thread.start();
                    return thread;
                })
                .toList();

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("Все письма разосланы!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ошибка ожидания отправки писем");
        }
    }
}
