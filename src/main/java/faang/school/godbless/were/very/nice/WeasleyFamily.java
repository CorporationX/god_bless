package faang.school.godbless.were.very.nice;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{"Помыть машину", "Подмести дом", "Постирать одежду", "Починить крышу"};
        completeaTsks(chores);
    }

    public static void completeaTsks(String[] chores) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Arrays.stream(chores)
                .forEach(a -> executorService.submit(() -> new Chore(a).run()));
        executorService.shutdown();
    }
}
