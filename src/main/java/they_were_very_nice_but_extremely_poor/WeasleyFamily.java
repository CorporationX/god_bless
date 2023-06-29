package they_were_very_nice_but_extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};

        ExecutorService executor = Executors.newCachedThreadPool();
        for (var chore: chores){
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
    }
}
