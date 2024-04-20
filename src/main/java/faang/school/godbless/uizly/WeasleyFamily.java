package faang.school.godbless.uizly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"мытьё посуды", "стирка", "убока", "глажка", "готовка"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores){
            Chore task = new Chore(chore);
            executorService.execute(task);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Что то пошло не так(");
        }
    }
}
