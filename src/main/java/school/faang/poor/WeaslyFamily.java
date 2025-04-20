package school.faang.poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeaslyFamily {

    public void getToWork(List<String> chores) {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(chore -> executor.execute(new Chore(chore)));
        executor.shutdown();
    }
}