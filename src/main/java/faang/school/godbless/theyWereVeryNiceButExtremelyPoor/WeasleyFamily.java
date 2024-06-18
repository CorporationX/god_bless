package faang.school.godbless.theyWereVeryNiceButExtremelyPoor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = new ArrayList<>();
        chores.add(new Chore("1"));
        chores.add(new Chore("2"));
        chores.add(new Chore("3"));
        chores.add(new Chore("4"));
        chores.add(new Chore("5"));

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.execute(chore);
        }
        executor.shutdown();
    }
}
