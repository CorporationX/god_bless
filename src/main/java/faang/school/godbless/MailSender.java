package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String... args) throws InterruptedException {
        int queue = 1000;
        int threadMax = 5;
        int threadCountMsg = queue / threadMax;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int startIndex = i * threadCountMsg + 1;
            int endIndex = (i + 1) * threadCountMsg + 1;
            executorService.execute(new SenderRunnable(startIndex, endIndex));
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
        Thread thread = new Thread(new SenderRunnable(1, 201));
        Thread thread2 = new Thread(new SenderRunnable(201, 401));
        Thread thread3 = new Thread(new SenderRunnable(401, 601));
        Thread thread4 = new Thread(new SenderRunnable(601, 801));
        Thread thread5 = new Thread(new SenderRunnable(801, 1001));
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println("Сообщения отправлены");
    }

}
