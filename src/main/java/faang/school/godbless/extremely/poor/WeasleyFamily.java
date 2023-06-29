package faang.school.godbless.extremely.poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String... args) {
        String[] chores = new String[]{"Помыть посуду", "Подмести", "Убрать в комноте", "Покормить сову", "Написать эссе"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
    }
}
