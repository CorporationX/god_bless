package school.faang.java.thread1.familyweasley;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WeasleyFamily {
    public static int RANDOM_RANGE = 100;
    ExecutorService executors;
    List<String> chores;

    public void workExecutors() {
        initClassData();
        AtomicInteger numberTask = new AtomicInteger();
        chores.forEach(taskName -> executors.execute(new Chore(numberTask.getAndIncrement(), taskName, getRandomInt())));
        executors.shutdown();
    }

    public void initClassData(){
        chores = List.of("помыть посуду", "подмести пол", "приготовить ужин", "Task 1", "Task 2",
                "Task 3", "Task 4", "Task 5", "Task 6", "Task 7", "Task 8", "Task 9", "Task 10");
        executors = Executors.newCachedThreadPool();
    }

    public int getRandomInt() {
        return new Random().nextInt(WeasleyFamily.RANDOM_RANGE);
    }
}