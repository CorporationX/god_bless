package faang.school.godbless.BJS224057;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for(String chore : chores){
            Chore task = new Chore(chore);
            executor.submit(task);
        }
        executor.shutdown();
    }
}
