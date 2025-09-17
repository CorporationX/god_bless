package school.faang.bsj2_91300;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int AWAIT_TIME = 1;
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final List<String> chores = List.of("помыть полы",
            "пропылесосить коврыы",
            "помыть окна",
            "вытереть пыль",
            "помыть посуду");

    public void makeChores() {
        for (String chore : chores) {
            Chore choreObject = new Chore(chore);
            executorService.submit(choreObject);
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                System.out.println("Задания выполнены");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}