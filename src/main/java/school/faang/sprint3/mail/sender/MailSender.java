package school.faang.sprint3.mail.sender;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {

    public static final Integer THREAD_COUNT = 5;

    public static void main(String[] args) {

        double allMessagesCount = 1000;
        int messageBatch = Math.max(1, (int) Math.round(allMessagesCount / THREAD_COUNT));
        List<Thread> threads = IntStream.range(0, THREAD_COUNT)
                .filter(currentThreadNumber -> currentThreadNumber * messageBatch < allMessagesCount)
                .mapToObj(currentThreadNumber -> {
                    int start = currentThreadNumber * messageBatch;
                    int end = (int) Math.min(start + messageBatch, allMessagesCount);
                    System.out.println(start + " " + end);
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
