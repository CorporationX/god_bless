package school.faang.weasley_chores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static List<String> chores = new ArrayList<>(
            List.of("помыть посуду", "подмести пол", "приготовить ужин",
                    "убрать в комнате", "накормить сову", "почистить котел"));

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String choreTitle : chores) {
            executor.execute(new Chore(choreTitle));
        }
        executor.shutdown();
    }
}
