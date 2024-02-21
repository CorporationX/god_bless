package faang.school.godbless;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String... args) {
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
    }
}
