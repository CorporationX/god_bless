package school.faang.microsoft;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new SenderRunnable(1, 200));

        List<Thread> threads = Arrays.asList(
            new Thread(new SenderRunnable(1, 200)),
            new Thread(new SenderRunnable(1, 200)),
            new Thread(new SenderRunnable(1, 200)),
            new Thread(new SenderRunnable(1, 200)),
            new Thread(new SenderRunnable(1, 200))
            );

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("Все письма отправлены");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
