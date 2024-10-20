package school.faang.parallel3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = Arrays.asList("помыть посуду", "подмести пол", "приготовить ужин",
            "вынести мусор", "купить продукты");
        ExecutorService executors = Executors.newCachedThreadPool();

        for (String chore :chores){
            executors.submit(new Chore(chore));
        }
        executors.shutdown();

        try{
            if(!executors.awaitTermination(5, TimeUnit.MINUTES)){
                System.out.println("Задачи не завершились за 5 минут. Останавливаем!");
                executors.shutdownNow();
            }
        } catch (InterruptedException e){
            executors.shutdownNow();
        }
    }
}
