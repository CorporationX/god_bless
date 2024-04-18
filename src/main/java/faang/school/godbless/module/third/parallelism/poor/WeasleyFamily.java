package faang.school.godbless.module.third.parallelism.poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = List.of(
            new Chore("Убраться"),
            new Chore("Помыть посуду"),
            new Chore("Помыть пол"),
            new Chore("Приготовить еду")
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}
