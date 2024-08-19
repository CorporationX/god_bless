package faang.school.godbless.task.multithreading.they.very.nice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "стирка", "глажка", "помыть пол"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, chores.length)
                .forEach(i -> {
                    executorService.submit(new Chore(chores[i]));
                });
        executorService.shutdown();
    }
}
