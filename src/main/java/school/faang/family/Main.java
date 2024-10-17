package school.faang.family;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Chore> task = new ArrayList<>();
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
        for (String chores1 : chores) {
            Chore chore = new Chore(chores1);
            task.add(chore);
        }

        ExecutorService service = Executors.newCachedThreadPool();
        for (Chore task1 : task) {
            service.submit(task1);

        }
        service.shutdown();
        if (service.awaitTermination(5, TimeUnit.MINUTES)){
            System.out.println("Задачи не завершились за 5 минуту, принудительно останавливаем...");
            service.shutdownNow();
            System.out.println("Остановлено!");
        }
    }
}
