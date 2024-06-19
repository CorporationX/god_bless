package faang.school.godbless.WeasleyFamily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }

        executor.shutdown();
    }
}
