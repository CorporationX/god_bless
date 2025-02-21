package school.faang.extremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();
    }
}
