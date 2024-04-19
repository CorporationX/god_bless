package faang.school.godbless.uizly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"мытьё посуды", "стирка", "убока", "глажка", "готовка"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores){
            Chore task = new Chore(chore);
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}
