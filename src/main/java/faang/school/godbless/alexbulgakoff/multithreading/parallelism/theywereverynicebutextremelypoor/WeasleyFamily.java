package faang.school.godbless.alexbulgakoff.multithreading.parallelism.theywereverynicebutextremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */

public class WeasleyFamily {
    public static void main(String[] args) {

        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все задачи по дому выполнены, можно отдыхать!");
    }
}
