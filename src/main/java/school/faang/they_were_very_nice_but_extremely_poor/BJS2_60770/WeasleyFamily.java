package school.faang.they_were_very_nice_but_extremely_poor.BJS2_60770;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final CountDownLatch countDownLatch = new CountDownLatch(chores.length);

    public void doHouseholdChores() throws InterruptedException {
        for (String chore : chores) {
            executorService.submit(() -> {
                new Chore(chore).run();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("Все задачи выполнены");
    }
}
