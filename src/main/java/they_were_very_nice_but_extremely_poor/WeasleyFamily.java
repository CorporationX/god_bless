package they_were_very_nice_but_extremely_poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    private static final List<Chore> CHORES = List.of(
            new Chore("Wash to dishes"),
            new Chore("Sweep the floor"),
            new Chore("Cook dinner")
    );

    public static void main(String[] args) {
        CHORES.forEach(SERVICE::submit);
        SERVICE.shutdown();
    }
}
