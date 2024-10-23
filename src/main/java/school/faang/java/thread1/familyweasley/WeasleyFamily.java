package school.faang.java.thread1.familyweasley;

import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class WeasleyFamily {

    public static int RANDOM_RANGE = 10;

    private int numberThreads;
    ExecutorService executors;
    List<String> chores;
    {
        chores = List.of("помыть посуду", "подмести пол", "приготовить ужин", "Task 1","Task 2","Task 3","Task 4","Task 5","Task 6","Task 7", "Task 8","Task 9", "Task 10");
    }

    public void initExecutors(){

        executors = Executors.newCachedThreadPool();

        chores.stream()
                .forEach(s -> {
                    executors.execute(new Chore());
                });

    }

    public int getRandomTime(){
        return Random.
    }
}