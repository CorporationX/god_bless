package very.nice.very.poor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"chore1", "chore2", "chore3", "chore4", "chore5", "chore6"};
        ExecutorService executorSerive = Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(chore -> executorSerive.execute(new Chore(chore)));
        executorSerive.shutdown();
        if (executorSerive.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            System.out.println("Все задачи выполнены");
        } else {
            executorSerive.shutdownNow();
        }
    }
}
