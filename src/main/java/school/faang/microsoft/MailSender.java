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

        int allTasks = 1000;
        int tasksForOneIteration = 200;
        int firstCount = 0;

        for (int i = tasksForOneIteration; i <= allTasks; i += tasksForOneIteration) {
            threads.add(new Thread(new SenderRunnable(firstCount, i)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println("Все письма отправлены");
            } catch (InterruptedException e) {
                throw new IllegalStateException("Поток был прерван", e);
            }
        }
        executorService.shutdown();
    }
}
