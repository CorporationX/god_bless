package school.faang.sprint3.mail.sender;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {

    public static final Integer THREAD_COUNT = 5;

    public static void main(String[] args) {

        int allMessagesCount = 1000;
        int actualThreadCount = Math.min(THREAD_COUNT, allMessagesCount);
        int messageBatch = Math.max(1, (int) Math.round((double) allMessagesCount / actualThreadCount));
        List<Thread> threads = IntStream.range(0, actualThreadCount)
                .mapToObj(batchIndex -> {
                    int start = batchIndex * messageBatch;
                    int end = Math.min(start + messageBatch, allMessagesCount);
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
