package school.faang.task_48541;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static final String WASH_DISHES = "помыть посуду";
    public static final String SWEEP_THE_FLOOR = "подмести пол";
    public static final String COOK_DINNER = "приготовить ужин";
    private static final String[] chores = new String[]{WASH_DISHES, SWEEP_THE_FLOOR, COOK_DINNER};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String s : chores) {
            Chore chore = new Chore(s);
            executor.submit(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершены!");
                executor.shutdownNow();
                System.out.println("Задачи принудительно завершены!");
            }
        } catch (InterruptedException e) {
            System.out.printf("Задачи принудительно выполнены с исключением: %s", e.getMessage());
            executor.shutdownNow();
        }
    }
}
