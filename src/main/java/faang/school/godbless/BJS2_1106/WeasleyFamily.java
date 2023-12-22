package faang.school.godbless.BJS2_1106;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            executorService.execute(new Chore(chores[i]));
        }
        executorService.shutdown();
    }
}
