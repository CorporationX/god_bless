package faang.school.godbless.cleaningtheweasleyfamily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public static void main(String... args) throws InterruptedException {
        String[] chores = {"Wash", "mopping floors", "washing dishes", "Cooking"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String task : chores) {
            executorService.submit(new Chore(task));
        }
        executorService.shutdown();
        boolean done = executorService.awaitTermination(1, TimeUnit.MINUTES);
        if (done) {
            System.out.println("Все задачи успешно выполнены");
        } else {
            System.out.println("Не все задачи успели выполниться за назначенное время");
        }
    }
}
