package faang.school.godbless.they_were_very_nice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};

        ExecutorService cachedTreads = Executors.newCachedThreadPool();
        for (String chore: chores){
            cachedTreads.execute(new Chore(chore));
        }
        cachedTreads.shutdown();
    }
}
