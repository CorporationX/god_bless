package faang.school.godbless.multithreading.parallelism.theywere;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {

        List<Chore> chores = Arrays.asList(new Chore("Убрать коврик"), new Chore("Помыть посуду"),
                new Chore("Перевести книгу на английский"), new Chore("Забрать ключи"));

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.execute(chore);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            try {
                System.out.println("Executor is not terminated, wait for it to terminate 1 second");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Executor is terminated");

    }
}
