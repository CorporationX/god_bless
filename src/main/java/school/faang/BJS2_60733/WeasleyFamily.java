package school.faang.BJS2_60733;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = new String[]{ "помыть посуду", "подмести пол", "приготовить ужин"};

        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            for (String task : chores) {
                executor.submit(new Chore(task));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
