package school.faang.newCachedThreadPool;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "постирать одежду", "полить цветы"};
        ExecutorService executor = Executors.newCachedThreadPool();

        Arrays.stream(chores)
                .forEach(chore -> executor.submit(new Chore(chore)));
    }
}