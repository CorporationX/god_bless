package faang.school.godbless.they_were_very_nice;

import java.lang.reflect.Array;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {

        String[] chores = {"first Task", "second Task", "third Task"};

        ExecutorService poolThreds = Executors.newFixedThreadPool(chores.length);

        for (String task : chores) {
            Thread thread = new Thread(new Chore(task));
            poolThreds.execute(thread);
        }

        poolThreds.shutdown();
    }


}
