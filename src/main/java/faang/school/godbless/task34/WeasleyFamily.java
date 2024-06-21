package faang.school.godbless.task34;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = new ArrayList<>();
        chores.add(new Chore("113"));
        chores.add(new Chore("1"));
        chores.add(new Chore("1132"));
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(Chore chore : chores) {
            cachedThreadPool.execute(chore);
        }
        cachedThreadPool.shutdown();
    }
}
