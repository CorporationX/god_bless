package school.faang.bjs2_81197;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WesleyFamily {
    String[] chores = new String[]{"мойку посуду", "вынос мусор", "приготвление ужина", "уборку за животными", "мойку машину"};

    ExecutorService executor = Executors.newCachedThreadPool();

    public void doChores() {

        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.submit(chore);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

}

