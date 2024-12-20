package derschrank.sprint03.task03.bjstwo_48427;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily extends Thread {
    private final List<Chore> chores;
    private ExecutorService executorService;
    private boolean isExecuted = false;

    public WeasleyFamily() {
        chores = new ArrayList<>();

    }

    public void addChore(Chore chore) {
        chores.add(chore);

        if (isExecuted) {
            submitOneChore(chore);
        }
    }

    @Override
    public void run() {
        executorService = Executors.newCachedThreadPool();
        isExecuted = true;

        for (Chore chore : new ArrayList<>(chores)) {
            submitOneChore(chore);
        }

        executorService.shutdown();
        isExecuted = false;
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Task wasn't ended, interrupt all manually");
            executorService.shutdownNow();
        }
    }

    private synchronized void submitOneChore(Chore chore) {
        executorService.submit(chore);
        chores.remove(chore);
    }

    public int getSize() {
        return chores.size();
    }
}
