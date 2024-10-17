package school.faang.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new SenderRunnable(1, 200));

        List<Thread> threads = new ArrayList<>();
        int firstCount = 0;
        for (int i = 200; i <= 1000; i += 200) {
            threads.add(new Thread(new SenderRunnable(firstCount, i)));
        }

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
