package school.BJS2_36656;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    private static String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.length; i++) {
            executorService.execute(new Chore(chores[i]));
        }
        executorService.shutdown();
    }

}
