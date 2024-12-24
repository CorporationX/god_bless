package school.faang.bjs248493;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static String[] chores = {"wash the dishes", "sweep the floor", "cook dinner"};
    private static CountDownLatch latch = new CountDownLatch(3);
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < chores.length; i++) {
            executorService.submit(new Chore(chores[i], latch));
        }
        executorService.shutdown();

        try {
            if (!latch.await(5, TimeUnit.SECONDS)) {
                System.out.println("Not all tasks were completed in 5 seconds");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Method " + Thread.currentThread().getName() + " complete work.");
    }
}
