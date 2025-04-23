package school.faang.they_were_very_nice_but_extremely_poor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        WeasleyFamily weasleyHousehold = new WeasleyFamily();
        String[] chores = weasleyHousehold.chores;

        System.out.print("Список задач:\n");
        Arrays.stream(chores)
                .map(task -> "  ⚡ " + task)
                .forEach(System.out::println);
        System.out.println("\n\u001B[36m==========================================\u001B[0m");
        System.out.println("\u001B[36m||  \u001B[33m🚀 ЗАПУСК ПОТОКОВ НА ВЫПОЛНЕНИЕ \u001B[36m||\u001B[0m");
        System.out.println("\u001B[36m==========================================\u001B[0m\n");
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
