package school.faang.task_48326;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChore(new Chore("помыть посуду"));
        weasleyFamily.addChore(new Chore("подмести пол"));
        weasleyFamily.addChore(new Chore("приготовить ужин"));

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : weasleyFamily.getChores()) {
            executorService.submit(chore);
        }

        executorService.shutdown();
    }
}
