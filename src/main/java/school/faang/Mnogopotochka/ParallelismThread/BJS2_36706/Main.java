package school.faang.Mnogopotochka.ParallelismThread.BJS2_36706;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : WeasleyFamily.chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
    }
}
