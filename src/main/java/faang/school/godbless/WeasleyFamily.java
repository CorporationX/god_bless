package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Task1","Task2","Task4","Task5",
                            "Task6","Task7","Task8", "Task9", "Task10",};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(String task: chores){
            Chore chore = new Chore(task);
            executorService.execute(chore);
        }

        executorService.shutdown();
    }
}
