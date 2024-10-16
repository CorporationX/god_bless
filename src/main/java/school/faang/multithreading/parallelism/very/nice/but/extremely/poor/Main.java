package school.faang.multithreading.parallelism.very.nice.but.extremely.poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChore("помыть посуду");
        weasleyFamily.addChore("подмести пол");
        weasleyFamily.addChore("приготовить ужин");

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : weasleyFamily.getChores()) {
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}
