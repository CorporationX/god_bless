package dima.evseenko.chore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final Chore[] chores = new Chore[3];

    public WeasleyFamily() {
        chores[0] = new Chore("Помыть пол");
        chores[1] = new Chore("Помыть посуду");
        chores[2] = new Chore("Сделать уроки");
    }

    public void executeChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();
    }
}
