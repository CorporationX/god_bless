package school.faang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "погладить кошку"};
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
    }
}
