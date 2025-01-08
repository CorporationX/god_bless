package were_nice_but_extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    String[] chore = {"помыть посуду", "подмести пол", "приготовить ужин"};

    ExecutorService executor = Executors.newCachedThreadPool();

}
