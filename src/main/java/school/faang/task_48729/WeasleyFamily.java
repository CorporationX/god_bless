package school.faang.task_48729;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "вытереть пыль",
                "выгулить собаку"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
