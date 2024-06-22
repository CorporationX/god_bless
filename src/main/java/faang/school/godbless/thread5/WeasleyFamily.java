package faang.school.godbless.thread5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        List<Chore> choreList = Arrays.stream(chores).map(Chore::new).toList();
        ExecutorService executor = Executors.newCachedThreadPool();
        choreList.forEach(executor::execute);
        executor.shutdown();
    }
}
