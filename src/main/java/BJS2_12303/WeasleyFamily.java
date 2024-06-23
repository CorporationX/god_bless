package BJS2_12303;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static List<Chore> chores;

    public static void main(String[] args) {
        chores = List.of(
                new Chore("Помыть посуду"),
                new Chore("Вытереть пыль"),
                new Chore("Приготовить покушать")
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        chores.forEach(executorService::execute);

        executorService.shutdown();
    }
}
