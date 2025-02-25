package school.faang.they_were_very_nice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    static String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executor.submit(chore);
        }
        executor.shutdown();
    }
}
