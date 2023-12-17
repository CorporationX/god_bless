package faang.school.godbless.multi_paral.task1microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        //Как рекомендовал делать Влад
        int messagesCount = 1000;
        int threadsCount = 5;
        int messageThread = messagesCount / threadsCount;
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * messageThread + 1;
            int endIndex = (i + 1) * messageThread + 1;
            executorService.execute(new SenderRunnable(startIndex, endIndex));
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);

        System.out.println("Все сообщения отправлены\n\n\n");

        // По условию
        Thread thread1 = new Thread(new SenderRunnable(1, 201));
        Thread thread2 = new Thread(new SenderRunnable(201, 401));
        Thread thread3 = new Thread(new SenderRunnable(401, 601));
        Thread thread4 = new Thread(new SenderRunnable(601, 801));
        Thread thread5 = new Thread(new SenderRunnable(801, 1001));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println("Все сообщения отправлены");
    }
}
