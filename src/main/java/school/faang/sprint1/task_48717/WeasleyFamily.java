package school.faang.sprint1.task_48717;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        String[] chores = {"помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "вытереть пыль",
                "постирать бельё"};
        for (String task : chores) {
            Chore chore = new Chore(task);
            threadPool.submit(chore);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
        threadPool.shutdown();
    }

}
