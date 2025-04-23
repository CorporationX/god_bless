import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final WeasleyFamily weasleyFamily = new WeasleyFamily();
        final List<Chore> chores = new ArrayList<>();

        for (String chore : weasleyFamily.getChores()) {
            chores.add(new Chore(chore));
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.execute(chore);
        }

        executor.shutdown();
    }
}

