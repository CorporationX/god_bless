package faang.school.godbless.big_bang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Task("a", "taskA"));
        executor.submit(new Task("b", "taskB"));
        executor.submit(new Task("c", "taskC"));
        executor.submit(new Task("d", "taskD"));
        //no new tasks will be accepted
        executor.shutdown();
    }
}
