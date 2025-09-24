package school.faang.bjs2_89880;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executor.submit(task);
        }

        executor.shutdown();
    }
}
