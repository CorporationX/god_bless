package school.faang.newCachedThreadPool;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {
        String[] chores = {"помыть посуду ", "подмести пол ", "приготовить ужин ", "постирать одежду ", "полить цветы "};
        ExecutorService executor = Executors.newCachedThreadPool();

        Arrays.stream(chores)
                .filter(chore -> chore != null && !chore.trim().isEmpty())
                .forEach(chore -> executor.submit(new Chore(chore)));
        executor.shutdown();
    }
}