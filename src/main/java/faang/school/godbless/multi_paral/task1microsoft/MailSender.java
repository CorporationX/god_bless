package faang.school.godbless.multi_paral.task1microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        //Как рекомендовал делать Влад
        int messagesCount = 1000;
        int threadsCount = 5;
        int messagePerThread = messagesCount / threadsCount;
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * messagePerThread + 1;
            int endIndex = (i + 1) * messagePerThread + 1;
            executorService.execute(new SenderRunnable(startIndex, endIndex));
        }

        executorService.shutdown();

        System.out.println("Все сообщения отправлены\n\n\n");

        // По условию
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * messagePerThread + 1;
            int endIndex = (i + 1) * messagePerThread + 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все сообщения отправлены");
    }
}
