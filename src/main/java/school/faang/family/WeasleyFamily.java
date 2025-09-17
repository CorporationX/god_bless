package school.faang.family;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    List<String> familyChores = new ArrayList<>(List.of("помыть посуду", "подмести пол"));

    ExecutorService executor = Executors.newCachedThreadPool();

    public void addChore(String task) {
        familyChores.add(task);
    }

    public void doChores() {
        for (String task : familyChores) {
            executor.submit(new Chore(task));
        }
        executor.shutdown();
    }

}
