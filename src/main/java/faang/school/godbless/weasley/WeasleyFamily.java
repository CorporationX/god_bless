package faang.school.godbless.weasley;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = new ArrayList<>();
        chores.add(new Chore("wash dishes"));
        chores.add(new Chore("swipe floors"));
        chores.add(new Chore("clean windows"));
        chores.add(new Chore("throw out trash"));
        chores.add(new Chore("do magic"));
        ExecutorService executor = Executors.newCachedThreadPool();
        for (var chore : chores) {
            executor.submit(chore);
        }
        executor.shutdown();
    }
}
