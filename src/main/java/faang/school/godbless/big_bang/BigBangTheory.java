package faang.school.godbless.big_bang;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BigBangTheory {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<?> t1 = executor.submit(new Task("a", "taskA"));
        Future<?> t2 = executor.submit(new Task("b", "taskB"));
        Future<?> t3 = executor.submit(new Task("c", "taskC"));
        Future<?> t4 = executor.submit(new Task("d", "taskD"));
        t1.get();
        t2.get();
        t3.get();
        t4.get();
        System.out.println("tasks are finished");
        executor.shutdown();
    }
}
