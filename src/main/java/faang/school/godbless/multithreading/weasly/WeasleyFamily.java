package faang.school.godbless.multithreading.weasly;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = new ArrayList<>(List.of(
                new Chore("Сделать уроки"),
                new Chore("Помыть посуду"),
                new Chore("Сделать уборку"),
                new Chore("Приготовить обед"),
                new Chore("Приготовить ужин")
        ));

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.execute(chore);
        }
        executorService.shutdown();

        while(!executorService.isTerminated()) {}
        System.out.println("Все задачи выполнены");
    }
}
