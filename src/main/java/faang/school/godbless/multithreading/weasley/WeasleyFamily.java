package faang.school.godbless.multithreading.weasley;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        Arrays.stream(chores)
                .parallel()
                .map(Chore::new)
                .forEach(executorService::execute);

        executorService.shutdown();
    }
}
