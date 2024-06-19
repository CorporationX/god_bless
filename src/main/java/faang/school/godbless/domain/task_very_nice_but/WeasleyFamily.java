package faang.school.godbless.domain.task_very_nice_but;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {

        String[] chores = {"уборка", "стирка", "готовка", "учеба"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
    }
}
