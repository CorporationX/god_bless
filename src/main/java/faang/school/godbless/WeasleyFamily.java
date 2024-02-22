package faang.school.godbless;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String... args) throws InterruptedException {
        List<String> chores = List.of("wash dishes",
                "wash clothes",
                "iron clothes",
                "clean floors",
                "make dinner");
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String str : chores) {
            executor.execute(new Chore(str));
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All tasks done!");
    }
}
