package kingslay.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight baristan = new Knight("Baristan");
        Knight mount = new Knight("Mount");
        baristan.addTrial(new Trial(baristan.getName(), "hold big log for hour"));
        baristan.addTrial(new Trial(baristan.getName(), "throw spear in the target"));
        mount.addTrial(new Trial(mount.getName(), "fight the bear"));
        mount.addTrial(new Trial(mount.getName(), "cut the tree with a sword"));
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            executor.execute(baristan::startTrails);
            executor.execute(mount::startTrails);
            executor.shutdown();
        }
    }
}
