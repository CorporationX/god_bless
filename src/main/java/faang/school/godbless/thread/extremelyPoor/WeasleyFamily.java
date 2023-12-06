package faang.school.godbless.thread.extremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};

        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : chores) {
            service.execute(new Chore(chore));
        }

        if (!service.awaitTermination(5, TimeUnit.SECONDS)) {
            service.shutdown();
        }

        System.out.println("All chores done");
    }
}
