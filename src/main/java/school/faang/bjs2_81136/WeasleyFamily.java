package school.faang.bjs2_81136;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "постирать белье"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();
    }
}
