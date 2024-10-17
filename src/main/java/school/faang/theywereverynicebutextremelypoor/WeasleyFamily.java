package school.faang.theywereverynicebutextremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {

        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

        ExecutorService pool = Executors.newCachedThreadPool();

        for (String chore : chores) {
            pool.execute(new Chore(chore));
        }

        pool.shutdown();
    }
}
