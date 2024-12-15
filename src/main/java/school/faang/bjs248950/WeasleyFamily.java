package school.faang.bjs248950;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "постирать бельё", "убрать комнату"};

        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (String task : chores) {
                Chore chore = new Chore(task);
                threadPool.submit(chore);
            }
        } finally {
            threadPool.shutdown();
        }

    }
}
