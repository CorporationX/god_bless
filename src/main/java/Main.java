import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final WeasleyFamily weasleyFamily = new WeasleyFamily();
        final List<Chore> chores = new ArrayList<>();

        for (String chore : weasleyFamily.getChores()) {
            chores.add(new Chore(chore));
        }

        final ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

