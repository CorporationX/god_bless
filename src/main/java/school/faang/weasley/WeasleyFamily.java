package school.faang.weasley;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {

        Chore[] chores = {new Chore("Помыть посуду"),
                new Chore("подмести пол"),
                new Chore("Приготовить ужин")};

        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(executor::submit);
        executor.shutdown();
    }
}
