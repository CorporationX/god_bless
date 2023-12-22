package faang.school.godbless.multithreading_parallelism.they_were_very_nice_but_extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String chores[] = new String[]{"Помыть посуду", "Помыть полы", "Постирать вещи", "Погладить", "Приготовить ужин", "Протереть пыль", "Подстричь газон"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.length; i++) {
            executorService.execute(new Chore(chores[i]));
        }

        executorService.shutdown();


    }
}
