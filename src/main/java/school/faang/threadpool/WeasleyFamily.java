package school.faang.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "постирать бельё",
                "покормить сову",
                "почистить камин",
                "прополоть огород"
        };
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : chores) {
            Chore chore = new Chore(choreName);
            executor.submit(chore);
        }
        executor.shutdown();
    }
}
