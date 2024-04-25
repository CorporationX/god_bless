package faang.school.godbless.Task_22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"To wash dishes", "To clean table", "To iron the clothes "};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();
    }
}
