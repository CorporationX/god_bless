package school.faang.bjs2_91310;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    String[] chores = { "помыть посуду", "подмести пол", "приготовить ужин" };

    ExecutorService executor = Executors.newCachedThreadPool();

    public void addChores() {
        for (String choreName : chores) {
            Chore chore = new Chore(choreName);
            executor.execute(chore);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи успели завершиться!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ожидание прервано");
        }
        System.out.println("Все задачи выполнены.");
    }
}