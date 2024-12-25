package school.faang.sprint3.task_48567;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        weasleyFamily.getChores().forEach(executorService::submit);

        executorService.shutdown();
    }
}
