package school.faang.sprint3.task48474theywerenice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static List<String> tasks = new ArrayList<>() {{
        add("Помыть посуду");
        add("Подмести пол");
        add("Приготовить ужин");
    }};

    public static void main(String[] args) {
        List<Chore> chores = tasks.stream().map(Chore::new).toList();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.execute(chore);
        }
        executor.shutdown();
    }
}
