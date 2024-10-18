package tasks.bjs2_36650;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static List<Chore> chores = new ArrayList<>();
    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        chores.add(new Chore("приготовить завтра"));
        chores.add(new Chore("приготовить обед"));
        chores.add(new Chore("помыть посуду"));
        chores.add(new Chore("подмести пол"));
        chores.add(new Chore("приготовить ужин"));
        chores.forEach(executor::execute);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Процессы не были корректно завершены !");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("В процессе работы программы произошла ошибка : " + e.getMessage());
        }
    }
}
