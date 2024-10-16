package school.faang.multythreading.weasley;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        List<String> chores = Arrays.asList("Помыть посуду", "Подмести пол", "Приготовить ужин");
        ExecutorService executorService = Executors.newCachedThreadPool();

        chores.forEach(chore -> executorService.submit(new Chore(chore)));
        executorService.shutdown();
    }
}
