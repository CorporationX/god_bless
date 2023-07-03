package faang.school.godbless.Sprint4.TheyWereVeryNice;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> tasks = new LinkedList<>();
        ExecutorService executors = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            tasks.add(new Chore("task" + i));
        }

        for (Chore task : tasks) {
            executors.execute(task);
        }

        executors.shutdown();
    }

}
