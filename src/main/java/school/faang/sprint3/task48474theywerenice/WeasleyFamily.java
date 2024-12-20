package school.faang.sprint3.task48474theywerenice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] tasks = {"помыть посуду", "подмести пол", "приготовить ужин"};
        List<Chore> chores = Arrays.stream(tasks).map(Chore::new).toList();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}