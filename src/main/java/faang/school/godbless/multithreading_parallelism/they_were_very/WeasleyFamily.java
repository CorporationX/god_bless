package faang.school.godbless.multithreading_parallelism.they_were_very;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"Почистить зубы", "Застелить кровать",
                "Приготовить завтрак", "Убраться в комнате", "Помыть посуду", "Постирать белье",
                "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            executorService.execute(new Chore(chores[i]));
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Рутинные дела закончены!");
    }
}
