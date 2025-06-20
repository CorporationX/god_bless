package school.faang.bjs2_81215;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public void doChores() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : chores) {
            Chore chore = new Chore(choreName);
            executor.submit(chore);
        }

        executor.shutdown();
    }

    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily();
        family.doChores();
    }
}
