package faang.school.godbless.sprint3.weasleyFamily;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores)
                .map(Chore::new)
                .forEach(executor::execute);
        executor.shutdown();
    }
}
