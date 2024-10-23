package goodAndBad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final List<Chore> chores = new ArrayList<>();
    private final ExecutorService pollTreads = Executors.newCachedThreadPool();

    public void execute() {
        chores.forEach(pollTreads::execute);
        pollTreads.shutdown();
    }

    public void addChore(Chore chore) {
        chores.add(chore);
    }

    public void removeChore(Chore chore) {
        chores.remove(chore);
    }

    public void printListChore() {
        chores.forEach(System.out::println);
    }
}
