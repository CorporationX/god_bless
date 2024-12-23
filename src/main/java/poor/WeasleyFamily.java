package poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static String[] chores = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин",
            "погладить одежду",
            "убрать в ванной"
    };

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executorService.submit(task);
        }
        executorService.shutdown();
    }
}

