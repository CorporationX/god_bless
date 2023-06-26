package faang.school.godbless.sprint3.They_were_nice;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] taskList = new String[]{"Clean up the house", "Clean up the garden", "Clean up the kitchen"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < taskList.length; i++) {
            Chore chore = new Chore(taskList[i]);
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}
