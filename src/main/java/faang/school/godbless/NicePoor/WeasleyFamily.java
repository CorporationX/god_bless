package faang.school.godbless.NicePoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService pool = Executors.newCachedThreadPool();

        for (String chore: chores){
            pool.execute(new Chore(chore));
        }

        pool.shutdown();
    }
}
