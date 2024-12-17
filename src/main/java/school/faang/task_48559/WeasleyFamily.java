package school.faang.task_48559;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int WAITING_TIME = 5;

    public static void main(String[] args) {

        List<Chore> choreList = new ArrayList<>(Arrays.asList(
                new Chore("сходить за хлебом"),
                new Chore("помыть посуду"),
                new Chore("убрать в комнате"),
                new Chore("приготовить ужин"),
                new Chore("пребить полку")
        ));

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : choreList) {
            executorService.submit(chore);
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}