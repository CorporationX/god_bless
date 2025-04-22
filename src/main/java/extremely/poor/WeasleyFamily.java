package extremely.poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
    }
}
