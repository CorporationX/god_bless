package school.faang.extremely_poor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final List<Chore> chores = new ArrayList<>();
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            chores.add(new Chore("Washing " + i));
            chores.add(new Chore("Clearing " + i));
            chores.add(new Chore("Drying " + i));
        }
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            threadPool.submit(chore);
        }
        threadPool.shutdown();
    }
}
