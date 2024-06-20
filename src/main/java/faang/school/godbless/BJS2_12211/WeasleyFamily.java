package faang.school.godbless.BJS2_12211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"помыть посуду", "приготовить еду", "убрать дом", "накормить животных", "полить цветы"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("все задачи по дому выполнены");
        }
    }
}
